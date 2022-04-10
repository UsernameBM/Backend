package com.example.backend.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;
    Customer customer;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/getCustomer")
    public Customer getCustomerByUsernamePassword(@RequestParam(value = "user_name") String user_name,
                                                  @RequestParam(value = "password") String password) {
        customer = customerService.getCustomerByUsernameAndPassword(user_name,password);
        return customer;
    }

    //Funkar ej som planerat
    @GetMapping("/addCustomer")
    public Customer addCustomer(@RequestParam(value = "firstname") String firstName, @RequestParam(value = "lastname") String lastName,
                                @RequestParam(value = "username") String user_name, @RequestParam(value = "password") String password) {
        customer = customerService.addCustomer(firstName,lastName, user_name, password);
        return customer;
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

    // /VERIFYPASSWORD
    // change information

}

   /** @GetMapping("/verifyLogin")
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
} **/

