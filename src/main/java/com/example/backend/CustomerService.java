package com.example.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Service
public class CustomerService {

    @Autowired
    CustomerDao customerDao;

    @GetMapping("/verifyLogin")
    public String getCustomerbyUsername(@RequestParam(value = "username") String user_name, @RequestParam(value = "password") String password) {
         boolean customerExist = customerDao.getCustomerByUsername(user_name,password);
         String customer = Boolean.toString(customerExist);

         return customer;
    }

    @GetMapping("/cancelLogin")
    public boolean getCustomerByUsername(@RequestParam(value = "username") String user_name, @RequestParam(value = "password") String password) {
        boolean customerNotExist = !customerDao.getCustomerByUsername(user_name,password);
        System.out.println(customerNotExist);

        return customerNotExist;
    }
}
