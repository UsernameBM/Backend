package com.example.backend.Seats;

import com.example.backend.seat_reservation.seat_reservation;
import com.example.backend.seat_reservation.seat_reservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SeatsController {

    @Autowired
    SeatsService seatsService;

    public SeatsController(SeatsService SeatsService){
        this.seatsService = seatsService;
    }


    @GetMapping("/getSeatsByid")
    public Seats getSeatsByid(@RequestParam(value = "id", defaultValue = "0")int id){
        return seatsService.getSeatsByid(id);
    }
}
