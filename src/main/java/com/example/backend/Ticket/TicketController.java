package com.example.backend.Ticket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TicketController {

    @Autowired
    TicketService ticketService;

    @GetMapping("/getTicket")
    public Ticket getTicketByCustomerId(@RequestParam (value = "costumer_id", defaultValue = "No id") int costumer_id) {
        return ticketService.getTicketByCustomerId(costumer_id);
    }

    @GetMapping("/insertTicket")
    public void insertTicket(@RequestParam(value = "price") double price,
                             @RequestParam(value = "ticket_amount") int ticket_amount,
                             @RequestParam(value = "costumer_id") int costumer_id,
                             @RequestParam(value = "idSeat") int idSeat,
                             @RequestParam(value = "time") String time,
                             @RequestParam(value = "movie_id") int movie_id,
                             @RequestParam(value = "idSalon") int idSalon,
                             @RequestParam(value = "seats_id") int seats_id
                             ){
        ticketService.insertTicket(price, ticket_amount, costumer_id, idSeat, time, movie_id, idSalon, seats_id);
    }

    @GetMapping("/deleteTicket")
    public void deleteTicket(@RequestParam(value = "idTicket", defaultValue = "-1") int idTicket){
        ticketService.deleteTicket(idTicket);
    }

}

