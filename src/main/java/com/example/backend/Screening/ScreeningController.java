package com.example.backend.Screening;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScreeningController {

    @Autowired
     ScreeningService screeningService;

    public ScreeningController(ScreeningService screeningService) {
        this.screeningService = screeningService;
    }

    @GetMapping("/requestScreening")
    public Screening findScreening(@RequestParam(value = "id") String id) {
        return screeningService.getScreeningById(id);
    }

}
