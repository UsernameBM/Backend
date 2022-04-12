package com.example.backend.PersonalSchedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class PersonalScheduleController {

    @Autowired
    PersonalScheduleService personalScheduleService;

    public PersonalScheduleController(PersonalScheduleService personalScheduleService){
        this.personalScheduleService = personalScheduleService;
    }

    @GetMapping("/getAllPersonalSchedule")
    public ArrayList<PersonalSchedule> getAllPersonalSchedule(){
        return personalScheduleService.getAllPersonalSchedule();
    }

    @GetMapping("/insertPersonalSchedule")
    public void insertPersonalSchedule(
                            @RequestParam(value = "idSalon", defaultValue = "No Salon")int idSalon,
                            @RequestParam(value = "idUser", defaultValue = "No User")int idUser,
                            @RequestParam(value = "Counter")String Counter,
                            @RequestParam(value = "Kitchen")String Kitchen,
                            @RequestParam(value = "date") String date){
        personalScheduleService.insertPersonalSchedule(date, idSalon, idUser, Counter, Kitchen);
    }
}
