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

    public void insertTicket(double price, int ticket_amount, int costumer_id, int idSeat, String time, int movie_id, int idSalon, int seats_id){
        ticketDao.insertTicket(price,ticket_amount,costumer_id,idSeat,time,movie_id,idSalon,seats_id);
    }

    public void deleteTicket(int idTicket){
        ticketDao.deleteTicket(idTicket);
    }



}


