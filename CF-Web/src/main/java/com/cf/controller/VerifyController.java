package com.cf.controller;

import com.cf.beans.Member;
import com.cf.beans.Page;
import com.cf.service.MemberService;
import com.cf.utils.Utils;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/verify")
public class VerifyController {
    @Autowired
    TaskService taskService;
    @Autowired
    MemberService memberService;
    @Autowired
    RepositoryService repositoryService;
    @RequestMapping("/toIndex")
    public String   toIndex(){
        return "verify/index";
    }

    @RequestMapping("/queryPages")
    @ResponseBody
    public Object queryPages(@RequestParam(value = "pageSize", required = false, defaultValue = "4") Integer pageSize,
                             @RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum, String keywords) {
        ArrayList<Map<String, Object>> data = new ArrayList<>();
        Map resMap = Utils.resMap();
        Integer skip = (pageNum - 1) * pageSize;
        TaskQuery taskQuery = taskService.createTaskQuery().processDefinitionKey("verify_user1").taskCandidateGroup("admins");
        List<Task> tasks = taskQuery.listPage(skip, pageSize);
        for (Task task : tasks) {
            Map<String, Object> dataMap = new HashMap<>();
            dataMap.put("taskId", task.getId());
            dataMap.put("taskName", task.getName());
            ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery().processDefinitionId(task.getProcessDefinitionId()).singleResult();
            dataMap.put("procName",processDefinition.getName());
            dataMap.put("procV",processDefinition.getVersion());
            String processInstanceId = task.getProcessInstanceId();

            try {
                Member member = memberService.queryMemberByInsId(processInstanceId);
                dataMap.put("member",member);
                data.add(dataMap);

            } catch (Exception e) {
                e.printStackTrace();
                resMap.put("res","fail");
            }
        }
        Long totalCount=taskQuery.count();
        Integer integerTotalCount=totalCount.intValue();
        Integer totalPages=0;
        if (pageSize>integerTotalCount) pageSize=integerTotalCount;
        if (integerTotalCount!=0){
             totalPages=(integerTotalCount%pageSize==0)?(integerTotalCount/pageSize):(integerTotalCount/pageSize+1);

        }
        Page page = new Page(pageNum, pageSize, integerTotalCount, totalPages, data);
        resMap.put("res",page);
        return resMap;
    }
    @RequestMapping("/details")
    public String details(Map map,Integer id){

        try {
           List<Map>  certiMap=  memberService.queryCertiByMemberId(id);
         Member member=   memberService.queryMemberById(id);
            map.put("certi",certiMap);
            map.put("member",member);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("res","fails");
        }
        return "verify/details";
    }
    @ResponseBody
    @RequestMapping("/pass")
    public Object pass(String taskId,Integer memberId){
        Map resMap = Utils.resMap();
        try {
            taskService.setVariable(taskId,"pass",true);
            taskService.setVariable(taskId,"memberId",memberId);
            taskService.complete(taskId);
            resMap.put("res",true);
        } catch (Exception e) {
            e.printStackTrace();
            resMap.put("res",false);
        }
        return resMap;
    }
    @ResponseBody
    @RequestMapping("/notPass")
    public Object notPass(String taskId,Integer memberId){
        Map resMap = Utils.resMap();
        try {
            taskService.setVariable(taskId,"pass",false);
            taskService.setVariable(taskId,"memberId",memberId);
            taskService.complete(taskId);
            resMap.put("res",true);
        } catch (Exception e) {
            e.printStackTrace();
            resMap.put("res",false);
        }
        return resMap;
    }
}
