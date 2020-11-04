package com.cf.dao;

import com.cf.beans.Member;
import com.cf.beans.Ticket;

import java.util.List;

public interface TicketMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Ticket record);

    Ticket selectByPrimaryKey(Integer id);

    List<Ticket> selectAll();

    int updateByPrimaryKey(Ticket record);

    Ticket queryByMemberId(Member user);

    Integer updateTicketStepByMemberId(Integer id, String step);

    Integer updateTicket(Ticket ticket);

    void updateTicketStatus(Integer memberId);
}