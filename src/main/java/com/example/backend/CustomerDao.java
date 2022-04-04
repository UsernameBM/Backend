package com.example.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class CustomerDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public boolean getCustomerByUsername(String user_name, String password) {
        String query = "SELECT * FROM movie.customer WHERE user_name =? AND password =?";

        try {
             Customer customer = jdbcTemplate.queryForObject(query, new RowMapper<Customer>() {

                    @Override
                    public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Customer cus = new Customer(rs.getInt("id"),
                                rs.getString("firstName"),
                                rs.getString("lastName"),
                                rs.getString("user_name"),
                                rs.getString("password"));
                        return cus;
                    }
                }, user_name, password);

             return true;

        } catch(Exception e) {
            e.printStackTrace();
            e.getCause();
        }
        return false;
    }
}


