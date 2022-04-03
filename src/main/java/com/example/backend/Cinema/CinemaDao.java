package com.example.backend.Cinema;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class CinemaDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Cinema getCinemaByName(String name){
        String query = "SELECT * FROM cinema WHERE name= ?";
        Cinema cinema = jdbcTemplate.queryForObject(query, new RowMapper<Cinema>() {
            @Override
            public Cinema mapRow(ResultSet rs, int rowNum) throws SQLException {
                Cinema cin = new Cinema(rs.getString("name"),
                        rs.getString("adress"),
                        rs.getString("tel_number"));
                return cin;
            }
        }, name);
        return cinema;
    }
}
