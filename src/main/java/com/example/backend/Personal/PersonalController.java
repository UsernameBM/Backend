package com.example.backend.Personal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonalController {

    @Autowired
    PersonalService personalService;
    Personal personal;

    public PersonalController(PersonalService personalService){
        this.personalService = personalService;
    }

    @GetMapping("/getPersonalByUsername")
    public Personal getPersonalByUsername(@RequestParam(value = "user_name", defaultValue = "No name")String user_name){
        return personalService.getPersonalByUsername(user_name);
    }

    @GetMapping("/insertPersonal")
    public void insertPersonal(@RequestParam(value = "firstname")String firstname,
                               @RequestParam(value = "lastname")String lastname,
                               @RequestParam(value = "tel_number")String tel_number,
                               @RequestParam(value = "email")String email,
                               @RequestParam(value = "bank")String bank,
                               @RequestParam(value = "banknumber")String banknumber,
                               @RequestParam(value = "user_name")String user_name,
                               @RequestParam(value = "password")String password,
                               @RequestParam(value = "Cinema_name")String Cinema_name){
        personalService.insertPersonal(firstname, lastname, tel_number, email, bank, banknumber, user_name, password, Cinema_name);
    }

    @GetMapping("/verifyPersonalUsername")
    public String verifyUsername(@RequestParam(value = "username")String user_name) {
        personal = personalService.verifyUsername(user_name);
        if (!(personal == null)){
            return "Personal exist";
        } else {
            return "Personal doesnt exist";
        }
    }

    @GetMapping("/updatePersonal")
    public void updatePersonal(@RequestParam(value = "firstname")String firstname,
                               @RequestParam(value = "lastname")String lastname,
                               @RequestParam(value = "tel_number") String tel_number,
                               @RequestParam(value = "email") String email,
                               @RequestParam(value = "bank") String bank,
                               @RequestParam(value = "banknumber")String banknumber,
                               @RequestParam(value = "user_name")String user_name,
                               @RequestParam(value = "password")String password,
                               @RequestParam(value = "Cinema_name")String Cinema_name,
                               @RequestParam(value = "idUser") int idUser){
        personalService.updatePersonal(firstname, lastname, tel_number, email, bank, banknumber, user_name, password, Cinema_name, idUser);
    }
}
