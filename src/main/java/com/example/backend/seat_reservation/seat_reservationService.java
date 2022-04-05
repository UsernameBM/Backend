package com.example.backend.seat_reservation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class seat_reservationService {
    @Autowired
    seat_reservationDAO seat_reservationDAO;
    seat_reservation seat_reservation;

    public seat_reservation getSeat_reservationByIdSeat(int idSeat){
        return seat_reservation = seat_reservationDAO.getSeat_reservationByidSeat(idSeat);
    }
}
