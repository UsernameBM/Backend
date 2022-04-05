package Ticket;

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
}

