package com.example.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Service
public class CustomerService {

    @Autowired
    CustomerDao customerDao;

    public Customer getCustomerbyUsername(String user_name) {
        Customer customer = customerDao.getCustomerByUsername(user_name);
        return customer;
        
    }
}