package com.example.backend.PersonalSchedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * http://localhost:8080/insertPersonalSchedule?idSalon=1&idUser=1&Counter=ja&Kitchen=nej&date=2022-04-29,09:00-15:30
 *
 *http://localhost:8080/deleteSchedule?id=1
 *
 * http://localhost:8080/getAllPersonalSchedule
 */
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
        personalScheduleService.insertPersonalSchedule(idSalon, idUser, Counter, Kitchen, date);
    }

    @GetMapping("/deleteSchedule")
    public void deleteSchedule(@RequestParam(value = "id", defaultValue = "-1")int id){
        personalScheduleService.deleteSchedule(id);
    }
}
