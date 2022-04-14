package com.example.backend.Screening;


import com.example.backend.Salon.Salon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

import java.sql.SQLException;

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

    @GetMapping("/addScreening")
    public String addScreening(@RequestParam(value = "time") String time, @RequestParam(value = "movieId") int movieId,
                               @RequestParam(value = "idSalon") int idSalon) {


        Screening screening = new Screening(time, movieId, idSalon);
        return screeningService.insertScreening(screening);
    }

    @GetMapping("/selectMovieTime")
    void selectMovieTime(@RequestParam(value = "time") String time, @RequestParam(value = "idMovie") int movie_id) throws SQLException {
        screeningService.selectMovieTime(time, movie_id);
    }

    @GetMapping("/getAllScreening")
    public ArrayList<Screening> getAllScreening(){
        return screeningService.getAllScreening();
    }
}
