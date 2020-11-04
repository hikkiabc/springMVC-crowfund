package com.cf.activiti.listener;

import com.cf.beans.Member;
import com.cf.service.MemberService;
import com.cf.service.TicketService;
import com.cf.utils.ApplicationContextUtils;
import com.cf.utils.Utils;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.ExecutionListener;
import org.springframework.context.ApplicationContext;

import java.util.Map;

public class PassListener implements ExecutionListener {
    @Override
    public void notify(DelegateExecution delegateExecution) {
        ApplicationContext applicationContext = ApplicationContextUtils.applicationContext;
        MemberService memberService = applicationContext.getBean(MemberService.class);
        TicketService ticketService = applicationContext.getBean(TicketService.class);
        Integer memberId = (Integer) delegateExecution.getVariable("memberId");
        Member member = new Member();
        Map resMap = Utils.resMap();
        member.setId(memberId);
        member.setStatus(2);
        try {
            memberService.updateStatus(member);
            ticketService.updateTicketStatus(memberId);

        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}
