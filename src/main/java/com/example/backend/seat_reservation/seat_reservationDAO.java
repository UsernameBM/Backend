package com.example.backend.seat_reservation;

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
        String query = "SELECT * FROM seat_reservation WHERE idSeat= ?";

        seat_reservation seat_reservation = jdbcTemplate.queryForObject(query, new RowMapper<seat_reservation>() {
            @Override
            public seat_reservation mapRow(ResultSet rs, int rowNum) throws SQLException {
                seat_reservation set = new seat_reservation(rs.getInt("idSeat"),
                        rs.getString("time"),
                        rs.getInt("movie_id"),
                        rs.getInt("idSalon"),
                        rs.getInt("seats_id"));
                return set;
            }
        }, idSeat);
        return seat_reservation;
    }
}
