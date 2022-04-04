package com.example.backend.Cinema;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CinemaController {

    @Autowired
    CinemaService cinemaService;

    public CinemaController(CinemaService cinemaService){
        this.cinemaService = cinemaService;
    }

    @GetMapping("/getCinemaByName")
    public Cinema getCinemaByName(@RequestParam(value = "name", defaultValue = "No name")String name){
        return cinemaService.getCinemaByName(name);


    }
}
