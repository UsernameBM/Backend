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
}