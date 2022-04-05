package com.example.backend.Ticket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketService {

    @Autowired
    TicketDao ticketDao;
    Ticket ticket;

    public Ticket getTicketByCustomerId(int costumer_id) {
       return ticket = ticketDao.getTicketByCustomerId(costumer_id);
    }
}


