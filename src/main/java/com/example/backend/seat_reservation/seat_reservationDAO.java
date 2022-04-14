package com.example.backend.seat_reservation;

import com.example.backend.Screening.Screening;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class seat_reservationDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public seat_reservation getSeat_reservationByidSeat(int idSeat){
        String query = "SELECT * FROM movie.seat_reservation WHERE idSeat= ?";

        seat_reservation seat_reservation = jdbcTemplate.queryForObject(query, new RowMapper<seat_reservation>() {
            @Override
            public seat_reservation mapRow(ResultSet rs, int rowNum) throws SQLException {
                seat_reservation set = new seat_reservation(rs.getInt("idSeat"),
                        rs.getString("time"),
                        rs.getInt("movie_id"),
                        rs.getInt("idSalon"),
                        rs.getInt("seats_id"),
                        rs.getInt("reserved"));
                return set;
            }
        }, idSeat);
        return seat_reservation;
    }

    // Lägg en bokning!
    public void makeReservation(int idSeat, String time, int movie_id, int idSalon, int seats_id, int reserved) {
        String query = "INSERT INTO movie.seat_reservation (idSeat, time, movie_id, idSalon, seats_id) VALUES(?,?,?,?,?)";

        int result = jdbcTemplate.update(query, idSeat, time, movie_id, idSalon, seats_id, reserved);

        if (result > 0) {
            System.out.println(result + " reservation has been added!");
        }
    }

    // Uppdatera seat_reservation (vilka platser som är bokade etc)
    public void updateSeatReservation(int idSeat, String time, int movie_id, int idSalon, int seats_id, int reserved) {
        String query = "UPDATE movie.seat_reservation SET idSeat = ?, time = ?, movie_id = ?, idSalon =?, seats_id =?, reserved=?";

        int result = jdbcTemplate.update(query, idSeat, time, movie_id, idSalon, seats_id);

        if (result > 0) {
            System.out.println(result + " reservation has been updated!");
        }
    }

        public void makeSeatReservation(int idSeat, int reserved) {
            String query = "UPDATE movie.seat_reservation SET reserved =? WHERE idSeat =?";

            int result = jdbcTemplate.update(query, idSeat, reserved);

            if(result > 0) {
                System.out.println(result + " seat have been booked");
            }

        }



}
