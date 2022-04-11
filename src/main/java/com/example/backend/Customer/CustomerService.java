package com.example.backend.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    CustomerDao customerDao;


    public Customer getCustomerByUsername(String user_name) {
        return customerDao.getCustomerByUsername(user_name);

    }
}