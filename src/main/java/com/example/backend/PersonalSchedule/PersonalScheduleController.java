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
    public void insertPersonalSchedule(@RequestParam(value = "date", defaultValue = "No date")String date,
                            @RequestParam(value = "idUser", defaultValue = "No user")int idUser,
                            @RequestParam(value = "idSalon", defaultValue = "No salon")int idSalon,
                            @RequestParam(value = "Kassa")String Kassa,
                            @RequestParam(value = "Kitchen")String Kitchen){
        personalScheduleService.insertPersonalSchedule(date, idUser, idSalon, Kassa, Kitchen);
    }
}
