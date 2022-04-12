package com.example.backend.Screening;


import com.example.backend.Movie.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ScreeningService {

    @Autowired
    ScreeningDao screeningDao;
    ArrayList<Screening> screenings;

    public String insertScreening(Screening screening){
        String salonAdded = "Your Salon has been added to the database with following Salon information: ";
        screeningDao.insertScreening(screening.getTime(), screening.getMovieId(), screening.getIdSalon());
        return salonAdded + " " + screening.getTime() + " " + screening.getMovieId() + " " + screening.getIdSalon();
    }

    public Screening getScreeningById(String id){
        Screening screening = screeningDao.getScreeningById(id);
                return screening;
    }

    public ArrayList<Screening> getAllScreening(){
        screenings = screeningDao.getAllScreening();
        return screenings;
    }
}
