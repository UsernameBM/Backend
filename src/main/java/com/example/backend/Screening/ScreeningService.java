package com.example.backend.Screening;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScreeningService {

    @Autowired
    ScreeningDao screeningDao;

    public void insertScreening(Screening screening){
        screeningDao.insertScreening(screening.getTime(), screening.getMovieId(), screening.getIdSalon());
    }

    public Screening getScreeningById(String id){
        Screening screening = screeningDao.getScreeningById(id);
                return screening;
    }
}
