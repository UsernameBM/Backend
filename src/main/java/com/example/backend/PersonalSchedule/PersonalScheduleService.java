package com.example.backend.PersonalSchedule;

import com.example.backend.Movie.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PersonalScheduleService {

    @Autowired
    PersonalScheduleDao personalScheduleDao;
    PersonalSchedule personalSchedule;
    ArrayList<PersonalSchedule> personalSchedules;

    public ArrayList<PersonalSchedule> getAllPersonalSchedule() {
        personalSchedules = personalScheduleDao.getAllPersonalSchedule();
        return personalSchedules;
    }

    public void insertPersonalSchedule(String date, int idUser, int idSalon, String Kassa, String Kitchen){
        personalScheduleDao.insertPersonalSchedule(date, idUser, idSalon, Kassa, Kitchen);
    }
}
