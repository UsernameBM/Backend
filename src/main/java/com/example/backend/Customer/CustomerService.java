package com.example.backend.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    CustomerDao customerDao;
    Customer customer;


    public Customer getCustomerByUsername(String user_name) {
        return customerDao.getCustomerByUsername(user_name);

    }

    //Funkar ej som planerat
    public Customer addCustomer(String firstname, String lastname, String user_name, String password) {
        customer = customerDao.addCustomer(firstname, lastname, user_name, password);
        return customer;
    }

    public Customer verifyUsername(String user_name) {
        customer = customerDao.verifyUsername(user_name);
        return customer;
    }

    public void insertCustomer(String firstname, String lastname, String user_name, String password){
        customerDao.insertCustomer(firstname, lastname, user_name, password);
    }

    public void updateCustomer(String firstName, String lastName, String user_name, String password, int id){
        customerDao.updateCustomer(firstName,lastName, user_name, password, id);
    }
}