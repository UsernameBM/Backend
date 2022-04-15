package com.example.backend.Customer;

import com.fasterxml.jackson.databind.introspect.TypeResolutionContext;
import net.bytebuddy.description.annotation.AnnotationSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.IncorrectResultSetColumnCountException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import java.sql.ResultSet;

@RestController
public class CustomerController {
    public static JWCustomerHandler jwHandler = new JWCustomerHandler();

    @Autowired
    CustomerService customerService;
    Customer customer;

    @Autowired
    HttpServletRequest request;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/getCustomer")
    public Customer getCustomerByUsername(@RequestParam(value = "user_name") String user_name) {
        customer = customerService.getCustomerByUsername(user_name);
        return customer;
    }

    @GetMapping("/authorize")    //kollar ifall kund finns i databasen
    public String authenticateCustomer(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password) {
        Customer c = customerService.getCustomerByUsername(username);

        if (c.getPassword().equals(password)) {
            String token = jwHandler.generateToken(c);
            return token;
        } else if (!c.getPassword().equals(password)) {
            return "wrong";

        } else if (c.getPassword() == null || c.getUser_name() == null) {

            return "wrong";
        } else
            return "wrong";
    }


    @GetMapping("/hello")
    public String hello() {
        return "hello";


    }

    @GetMapping("/checkToken")
    public String checkToken(@RequestParam(value = "token") String token){
        return jwHandler.validateToken(token);
    }

    private String extractToken(){
        String bearer = request.getHeader("Autorization");
        String onlyToken = bearer.substring(6);
        return onlyToken;

    }

    //Funkar ej som planerat
    @GetMapping("/addCustomer")
    public Customer addCustomer(@RequestParam(value = "firstname") String firstName, @RequestParam(value = "lastname") String lastName,
                                @RequestParam(value = "username") String user_name, @RequestParam(value = "password") String password) {
        customer = customerService.addCustomer(firstName, lastName, user_name, password);
        return customer;
    }

    @GetMapping("/insertCustomer")
    public String insertCustomer(@RequestParam(value = "firstname") String firstName, @RequestParam(value = "lastname") String lastName,
                                 @RequestParam(value = "username") String user_name, @RequestParam(value = "password") String password) {
        customerService.insertCustomer(firstName, lastName, user_name, password);

        String newCustomer = "Customer has successfully been inserted in DB";
        System.out.println(newCustomer);
        return newCustomer;
    }


    @GetMapping("/verifyCustomerUsername")
    public Customer VerifyCustomerByUsername(@RequestParam(value = "user_name") String user_name) {
        try {
            customer = customerService.getCustomerByUsername(user_name);
            if (!(customer == null)) {
                System.out.println("Customer exist");
                return customer;
            }
        } catch (Exception e) {
            e.getMessage();
        }
        System.out.println("Customer dosent exist");
        return null;
    }
}
