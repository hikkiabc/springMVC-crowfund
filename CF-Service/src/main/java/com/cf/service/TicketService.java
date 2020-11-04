package com.cf.service;

import com.cf.beans.Member;
import com.cf.beans.Ticket;

public interface TicketService {
    Ticket queryTicketByUserId(Member user);

    Integer insert(Ticket newTicket);

    Integer updateTicketStepByMemberId(Integer user, String step);

    Integer updateTicket(Ticket ticket);

    void updateTicketStatus(Integer memberId);
}
