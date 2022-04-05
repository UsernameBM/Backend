package com.example.backend.Seats;

import com.example.backend.seat_reservation.seat_reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class SeatsDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Seats getSeatsByid(int id){
        String query = "SELECT * FROM seats WHERE id= ?";

        Seats seats = jdbcTemplate.queryForObject(query, new RowMapper<Seats>() {
            @Override
            public Seats mapRow(ResultSet rs, int rowNum) throws SQLException {
                Seats se = new Seats(rs.getInt("id"),
                        rs.getInt("seat"),
                        rs.getInt("row"),
                        rs.getInt("idSalon"),
                        rs.getString("cinema_name"));
                return se;
            }
        }, id);
        return seats;
    }
}
