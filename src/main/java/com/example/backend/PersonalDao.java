package com.example.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

public class PersonalDao {

    @Repository
    public class CustomerDao {

        @Autowired
        private JdbcTemplate jdbcTemplate;

    }
}
