package com.example.backend.Personal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonalController {

    @Autowired
    PersonalService personalService;

    public PersonalController(PersonalService personalService){
        this.personalService = personalService;
    }

    @GetMapping("/getPersonalByUsername")
    public Personal getPersonalByUsername(@RequestParam(value = "user_name", defaultValue = "No name")String user_name){
        return personalService.getPersonalByUsername(user_name);
    }
}
