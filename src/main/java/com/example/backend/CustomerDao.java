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

    public Customer getCustomerByUsername(String user_name) {
        String query = "SELECT * FROM movie.customer WHERE user_name =?";

        Customer customer = jdbcTemplate.queryForObject(query, new RowMapper<Customer>() {

            @Override
            public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
                Customer cus = new Customer(rs.getInt("customer_id"),
                        rs.getString("customer_firstName"),
                        rs.getString("customer_lastName"),
                        rs.getString("customer_user_name"),
                        rs.getString("customer_password"));
                return cus;
            }
        },user_name);

        return customer;
    }

}
