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

    public void makeReservation(int idSeat, String time, int movie_id, int idSalon, int seats_id, Byte reserved) {
        seat_reservationDAO.makeReservation(idSeat, time, movie_id, idSalon, seats_id, reserved);
    }

    public void updateSeatReservation(int idSeat, String time, int movie_id, int idSalon, int seats_id, Byte reserved) {
        seat_reservationDAO.updateSeatReservation(idSeat,time,movie_id,idSalon,seats_id,reserved);
    }

    void makeSeatReservation(int idSeat, Byte reserved) {
        seat_reservationDAO.makeSeatReservation(idSeat, reserved);
    }

    public void insertBooking(String userName, int idseat, String time, int movieId, int idSalon, int seatsId) {
        seat_reservationDAO.insertBooking(userName, idseat,time,movieId,idSalon,seatsId);

    }
}
