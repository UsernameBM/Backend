package com.example.backend.Salon;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

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
                }

