package com.example.backend.Cinema;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CinemaService {

    @Autowired
    CinemaDao cinemaDao;
    Cinema cinema;

    public Cinema getCinemaByName(String name){
        return cinema = cinemaDao.getCinemaByName(name);
    }
}
