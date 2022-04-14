package com.example.backend.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
public class CustomerDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Customer getCustomerByUsername(String user_name) {
        String query = "SELECT * FROM movie.customer WHERE user_name= ?";

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
        }, user_name);
        return customer;
    }

    public void addCustomer(String firstName, String lastname, String user_name,
                                String password) {

        String query = "INSERT INTO movie.customer (firstName, lastName, user_name, password) VALUES (?, ?, ?, ?)";

        int result = jdbcTemplate.update(query, firstName, lastname, user_name, password);

        if (result > 0) {
            System.out.println(result + " customer has been added!");
        }
    }

    public void verifyUsername(String user_name) throws SQLException {

        String query = "SELECT user_name FROM movie.customer WHERE user_name = ?";

        jdbcTemplate.queryForObject(query, new RowMapper<Customer>() {
            @Override
            public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
                Customer cus = new Customer(rs.getInt("id"),
                        rs.getString("firstName"),
                        rs.getString("lastName"),
                        rs.getString("user_name"),
                        rs.getString("password"));
                return cus;
                }
        }, user_name);
    }
}







