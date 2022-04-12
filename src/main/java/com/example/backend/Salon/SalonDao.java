package com.example.backend.Salon;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class SalonDao {


    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insertSalon(int seats, int row, String cinemaName) {
        String query = "INSERT INTO salon (seats, `row`, cinema_name) VALUES(?,?,?)"; //insert values to the database

        int result = jdbcTemplate.update(query, seats, row, cinemaName);

        if (result > 0) {
            System.out.println(result + " A salon has been added to the database");
        }
    }


    public Salon getSalonById(String id){

        String query = "SELECT * FROM salon WHERE idSalon =?";

        Salon salon = jdbcTemplate.queryForObject(query,  new RowMapper<Salon>() {

            @Override
            public Salon mapRow(ResultSet rs, int rowNum) throws SQLException {
                Salon sal = new Salon(rs.getInt("idSalon"),
                        rs.getInt("seats"),
                        rs.getInt("row"),
                        rs.getString("cinema_name")
                );
                return sal;
            }
            },id);

        return salon;

    }

    public ArrayList<Salon> getAllSalons(){
        String query = "SELECT * FROM salon";
        ArrayList<Salon> salons = new ArrayList<>();
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(query);

        for (Map<String, Object> row : rows){
            Salon salon = new Salon(
                    (int) row.get("idSalon"),
                    (int) (row.get("seats")),
                    (int) (row.get("row")),
                    String.valueOf(row.get("cinema_name")));
            salons.add(salon);
        }
        return salons;
    }
}

