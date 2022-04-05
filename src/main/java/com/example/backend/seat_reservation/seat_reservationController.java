package com.example.backend.seat_reservation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class seat_reservationController {

    @Autowired
    seat_reservationService seat_reservationService;

    public seat_reservationController(seat_reservationService seat_reservationService){
        this.seat_reservationService = seat_reservationService;
    }


    @GetMapping("/getseat_reservationByidSeat")
    public seat_reservation getseat_reservationByidSeat(@RequestParam(value = "idSeat", defaultValue = "0")int idSeat){
        return seat_reservationService.getSeat_reservationByIdSeat(idSeat);
    }
}
