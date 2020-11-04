package com.cf.controller;

import com.cf.activiti.listener.NotPassListener;
import com.cf.activiti.listener.PassListener;
import com.cf.beans.Member;
import com.cf.beans.MemberCerti;
import com.cf.beans.Ticket;
import com.cf.service.MemberService;
import com.cf.service.TicketService;
import com.cf.utils.DataWraper;
import com.cf.utils.Utils;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.*;

@RequestMapping("/member")
@Controller
public class MemberController {
    @Autowired
    MemberService memberService;
    @Autowired
    TicketService ticketService;
    @Autowired
    TaskService taskService;
@Autowired
    RuntimeService runtimeService;
    @RequestMapping("/toVerify")
    public String toVerify(HttpSession session) {
        Member user = (Member) session.getAttribute("user");
        Ticket ticket = ticketService.queryTicketByUserId(user);
        if (ticket == null) {
            Ticket newTicket = new Ticket();
            newTicket.setMemberId(user.getId());
            newTicket.setStep("updateAccType");
            newTicket.setStatus("0");
            Integer res = ticketService.insert(newTicket);
        } else {
            String step = ticket.getStep();
            if ("updateAccType".equals(step)) return "member/verify";
            if ("upload".equals(step)) return "redirect:/member/toUpload";
            if ("email".equals(step)) return "member/email";
            if ("verifyCode".equals(step)) return "member/code";
            if ("finish".equals(step)) return "redirect:toMemberIndex";
        }
        return "member/verify";
    }

    @RequestMapping("/updateAccType")
    @ResponseBody
    public Object updateAccType(Integer typeId, HttpSession session) {
        Member user = (Member) session.getAttribute("user");

        Map resMap = Utils.resMap();
        user.setType(typeId);


        try {
            Integer res = memberService.updateAccTypeById(user);
            String step="upload";
            Integer updateStep = ticketService.updateTicketStepByMemberId(user.getId(),step);
            resMap.put("res", res == 1);
        } catch (Exception e) {
            e.printStackTrace();
            resMap.put("res", "fail");
        }
        return resMap;
    }

    @RequestMapping("/toUpload")
    public String toUpload(Map map,HttpSession session){
        Member user = (Member) session.getAttribute("user");
        try {
            List certiList= memberService.queryCertiByAccType(user.getType());
            map.put("certiList",certiList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/member/upload";
    }
    @ResponseBody
    @RequestMapping("/upload")
    public Object upload(DataWraper dataWraper,HttpSession session ) throws IOException {
        List<MemberCerti> memberCertis = dataWraper.getMemberCertis();
        Member user = (Member) session.getAttribute("user");
        String realPath = session.getServletContext().getRealPath("/upload");
        for (MemberCerti memberCerti : memberCertis) {
            String originalFilename = memberCerti.getMultipartFile().getOriginalFilename();
            String extName = originalFilename.substring(originalFilename.lastIndexOf("."));
            String filename = UUID.randomUUID().toString() + extName;
            String filepath = realPath + "\\certiPics\\" + filename;

            memberCerti.getMultipartFile().transferTo(new File(filepath));
            memberCerti.setFilename(filename);
            memberCerti.setMemberId(user.getId());

        }
        Map resMap = Utils.resMap();
        try {
            Integer res= memberService.insertMemberCerti(memberCertis);
            ticketService.updateTicketStepByMemberId(user.getId(), "email");
            resMap.put("res",true);
        } catch (Exception e) {
            e.printStackTrace();
            resMap.put("res","fail");
        }
        return resMap;

    }
    @RequestMapping("/toEmailVerify")
    public String toEmailVerify(){

        return "member/email";
    }
    @RequestMapping("/verifyEmail")
    @ResponseBody
    public Object verifyEmail(HttpSession session,String email){
        Member user = (Member) session.getAttribute("user");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i <4 ; i++) {
            stringBuilder.append(new Random().nextInt(10 ));
        }

        Map resMap = Utils.resMap();
        Map<String, Object> variableMap = new HashMap<>();
        variableMap.put("to",email);
variableMap.put("user",user.getNickname());
        variableMap.put("code",stringBuilder.toString());
        variableMap.put("passListner",new PassListener());
        variableMap.put("notPassListner",new NotPassListener());
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("verify_user1",variableMap);

        Ticket ticket = ticketService.queryTicketByUserId(user);
        ticket.setCaptcha(stringBuilder.toString());
        ticket.setStep("verifyCode");
        ticket.setProcid(processInstance.getId());
        try {
            Integer res= ticketService.updateTicket(ticket);
            resMap.put("res",res);
        } catch (Exception e) {
            e.printStackTrace();
            resMap.put("res","fail");

        }
        return resMap;
    }
    @RequestMapping("/toCodeVerify")
    public String toCodeVerify(){
        return "member/code";
    }
    @RequestMapping("/verifyCode")
    @ResponseBody
    public Object verifyCode(HttpSession session,String code){
        Map resMap = Utils.resMap();
        Member user = (Member) session.getAttribute("user");
        Ticket ticket = ticketService.queryTicketByUserId(user);
        if (ticket.getCaptcha().equals(code)){
            ticketService.updateTicketStepByMemberId(user.getId(),"finish");
user.setStatus(1);
            Task task = taskService.createTaskQuery().processInstanceId(ticket.getProcid()).taskAssignee(user.getNickname()).singleResult();
            taskService.complete(task.getId());
            memberService.updateStatus(user);
            resMap.put("res",true);
        }else {
            resMap.put("res",false);
        }
        return resMap;
    }
    @RequestMapping("/toFinish")
    public String toFinish(){
        return "member/finish";
    }
}

