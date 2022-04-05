package com.example.backend.Seats;

import com.example.backend.seat_reservation.seat_reservation;
import com.example.backend.seat_reservation.seat_reservationDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeatsService {
    @Autowired
    SeatsDAO SeatsDAO;
    Seats Seats;

    public Seats getSeatsByid(int id){
        return Seats = SeatsDAO.getSeatsByid(id);
    }
}
