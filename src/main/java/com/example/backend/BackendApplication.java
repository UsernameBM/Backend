package com.example.backend;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication

public class BackendApplication {
    @Autowired
    JdbcTemplate jdbcTemplate;


    public static void main(String[] args) {SpringApplication.run(BackendApplication.class, args);}

}
