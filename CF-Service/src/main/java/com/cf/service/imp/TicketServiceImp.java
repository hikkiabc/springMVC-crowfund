package com.cf.service.imp;

import com.cf.beans.Member;
import com.cf.beans.Ticket;
import com.cf.dao.TicketMapper;
import com.cf.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketServiceImp implements TicketService {
    @Autowired
    TicketMapper ticketMapper;
    @Override
    public Ticket queryTicketByUserId(Member user) {
        return ticketMapper.queryByMemberId(user);
    }

    @Override
    public Integer insert(Ticket newTicket) {
        return ticketMapper.insert(newTicket);
    }

    @Override
    public Integer updateTicketStepByMemberId(Integer id, String step) {
        return ticketMapper.updateTicketStepByMemberId(id,step);
    }

    @Override
    public Integer updateTicket(Ticket ticket) {
        return ticketMapper.updateTicket(ticket);
    }

    @Override
    public void updateTicketStatus(Integer memberId) {
        ticketMapper.updateTicketStatus(memberId);
    }
}
