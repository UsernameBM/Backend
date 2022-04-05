package com.example.backend.Salon;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SalonController {

    @Autowired
    SalonService salonService;

    public SalonController(SalonService salonService){this.salonService = salonService;}

    @GetMapping("/requestSalon")
    public Salon findSalon(@RequestParam(value = "id") String id){
        return salonService.getSalonById(id);
    }
}

