package com.example.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

public class TicketDao {

    @Repository
    public class ticketDao {

        @Autowired
        private JdbcTemplate jdbcTemplate;

    }
}