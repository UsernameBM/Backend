package com.example.backend.Customer;

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

    public Customer getCustomerByUsernamePassword(String user_name, String password) {
        String query = "SELECT * FROM movie.customer WHERE user_name= ? AND password=?";

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
        return customer;
    }

    //Funkar ej som planerat
    public Customer addCustomer(String firstName, String lastname, String user_name,
                                String password) {
        String query = "INSERT INTO movie.customer (firstName, lastName, user_name, password) VALUES (?, ?, ?, ?)";

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
        }, firstName, lastname, user_name, password);

        return customer;
    }

    //Fixade addCustomer:)
    public void insertCustomer(String firstname, String lastname, String user_name, String password) {
        String query = "INSERT INTO movie.customer (firstName, lastName, user_name, password) VALUES (?, ?, ?, ?)";
        int result = jdbcTemplate.update(query, firstname, lastname, user_name, password);

        if (result > 0){
            System.out.println(result + " customer has been added!");
        }
    }


    //BOOLEAN?? OM ETT ANVÄNDARNAMN ÄR REGISTRERAT (finns i databasen) ska man inte kunna registrera den användaren igen. Utan välja ett nytt användarnamn
    public Customer verifyUsername(String user_name) {
        //String query = "SELECT EXISTS (SELECT user_name FROM movie.customer WHERE user_name = ?)";

        String query = "SELECT * FROM movie.customer WHERE user_name = ?";
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

}






