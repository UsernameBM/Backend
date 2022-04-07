package com.example.backend.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    CustomerDao customerDao;
    Customer customer;

    public Customer getCustomerByUsernameAndPassword(String user_name, String password) {
        customer = customerDao.getCustomerByUsernamePassword(user_name, password);
        return customer;
    }

    public Customer addCustomer(String firstname, String lastname, String user_name, String password) {
        customer = customerDao.addCustomer(firstname, lastname, user_name, password);
        return customer;
    }

    public Customer verifyUsername(String user_name) {
        customer = customerDao.verifyUsername(user_name);
        return customer;
    }
}