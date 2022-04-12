package com.example.backend.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
    public static JWCustomerHandler jwHandler = new JWCustomerHandler();

    @Autowired
    CustomerService customerService;
    Customer customer;



    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/getCustomer")
    public Customer getCustomerByUsernamePassword(@RequestParam(value = "user_name") String user_name)
                                                   {
        customer = customerService.getCustomerByUsername(user_name);
        return customer;
    }

    @GetMapping("/authorize")    //kollar ifall kund finns i databasen
    public String authenticateCustomer(@RequestParam(value="username") String username, @RequestParam(value ="password") String password) {
        Customer c = customerService.getCustomerByUsername(username);
        if (c.getPassword().equals(password)) {
            String token = jwHandler.generateToken(c);
            return "right password";

        }else if (!c.getPassword().equals(password)) {
            return "wrong password or username";

        }
        return "wrong password or username";
    }



    @GetMapping("/hello")
    public String hello() {
        return "hello";


    }
    @GetMapping("/checkToken")
    public String checkToken(@RequestParam(value = "token") String token){
        return jwHandler.validateToken(token);
    }

    @GetMapping("/insertCustomer")
    public void insertCustomer(@RequestParam(value = "firstname") String firstName, @RequestParam(value = "lastname") String lastName,
                               @RequestParam(value = "username") String user_name, @RequestParam(value = "password") String password){
        customerService.insertCustomer(firstName, lastName, user_name, password);
    }

    @GetMapping("/verifyCustomerUsername")
    public String verifyUsername(@RequestParam(value = "username") String user_name) {
        customer = customerService.verifyUsername(user_name);
        if(!(customer == null)){
            return "Customer exist";
        } else {
            return "Customer doesnt exist";
        }
    }


}



