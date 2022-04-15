package com.example.backend.seat_reservation;

import com.example.backend.Customer.JWCustomerHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;

@RestController
public class seat_reservationController {

    @Autowired
    seat_reservationService seat_reservationService;
    private JWCustomerHandler jwHandler;

    @Autowired
    HttpServletRequest request;

    public seat_reservationController(seat_reservationService seat_reservationService){
        this.seat_reservationService = seat_reservationService;
    }

    @GetMapping("/getseat_reservationByidSeat")
    public seat_reservation getseat_reservationByidSeat(@RequestParam(value = "idSeat", defaultValue = "0")int idSeat){
        return seat_reservationService.getSeat_reservationByIdSeat(idSeat);
    }

    @GetMapping("/makeReservation")
    public void makeReservation(@RequestParam(value = "idSeat") int idSeat, @RequestParam(value = "time") String time,
                                @RequestParam(value = "movie_id") int movie_id, @RequestParam(value = "idSalon") int idSalon,
                                @RequestParam(value= "seats_id") int seats_id, @RequestParam(value= "reserved") Byte reserved) {
        seat_reservationService.makeReservation(idSeat, time, movie_id, idSalon, seats_id, reserved);
    }
    @GetMapping("/updateSeatReservation")
    public void updateSeatReservation(@RequestParam(value = "idSeat") int idSeat, @RequestParam(value = "time") String time,
                                      @RequestParam(value = "movie_id") int movie_id, @RequestParam(value = "idSalon") int idSalon,
                                      @RequestParam(value= "seats_id") int seats_id, @RequestParam(value= "reserved") Byte reserved) {
        seat_reservationService.updateSeatReservation(idSeat, time, movie_id, idSalon, seats_id, reserved);
    }

    // 1 for true, 0 for false
    @GetMapping("/makeSeatReservation")
    public String makeSeatReservation(@RequestParam(value = "idSeat") int idSeat, @RequestParam(value = "reserved") Byte reserved) {
        seat_reservationService.makeSeatReservation(idSeat, reserved);

        if(reserved == 0) {
            return "Seat is not reserved!";
        }else {
            return "Seat is reserved!";
        }
    }

    @GetMapping("/bookMovieWithToken")
    public String bookMovieWithToken(@RequestParam(value = "idSeat") int idseat, @RequestParam(value = "time") String time,
                                     @RequestParam(value = "movieId") int movieId, @RequestParam(value = "idSalon") int idSalon,
                                     @RequestParam(value = "seatsId") int seatsId) {
        String token = extractToken();
        String subject = jwHandler.validateToken(token);
        if (subject.equals("invalid token")) {
            return "please log in again";
        } else seat_reservationService.insertBooking(subject, idseat, time, movieId, idSalon,seatsId);
        return "Your have booked your tickets";

    }

    private String extractToken() {
        String bearer = request.getHeader("Autorization");
        String onlyToken = bearer.substring(6);
        return onlyToken;
    }

}
