package com.example.backend.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class CustomerService {

    @Autowired
    CustomerDao customerDao;
    Customer customer;

    public Customer getCustomerByUsername(String user_name) {
        return customerDao.getCustomerByUsername(user_name);
    }

    public void addCustomer(String firstname, String lastname, String user_name, String password) {
        customerDao.addCustomer(firstname, lastname, user_name, password);
    }

    public void verifyUsername(String user_name) throws SQLException {
      customerDao.verifyUsername(user_name);
    }

}