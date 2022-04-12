package com.example.backend.Salon;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.ArrayList;

@RestController
public class SalonController {

    @Autowired
    SalonService salonService;

    public SalonController(SalonService salonService){this.salonService = salonService;}

    @GetMapping("/requestSalon")
    public Salon findSalon(@RequestParam(value = "id") String id) {
        return salonService.getSalonById(id);
    }

    @GetMapping("/addSalon")
    public String addSalon(@RequestParam(value = "seats") int seats, @RequestParam(value = "row") int row,
                           @RequestParam(value = "cinemaName") String cinemaName) {
        int idSalon = 0;

        Salon salon = new Salon(idSalon, seats, row, cinemaName);
        return salonService.insertSalon(salon);

    }

    @GetMapping("/getAllSalons")
    public ArrayList<Salon> getAllSalons(){
        return salonService.getAllSalons();
    }
}


