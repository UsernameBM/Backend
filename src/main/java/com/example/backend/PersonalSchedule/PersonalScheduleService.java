package com.example.backend.PersonalSchedule;

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

    public void insertPersonalSchedule(int idSalon, int idUser, String Counter, String Kitchen, String date ){
        personalScheduleDao.insertPersonalSchedule(idSalon, idUser, Counter, Kitchen, date);

    }

    public void deleteSchedule(int id){
        personalScheduleDao.deleteSchedule(id);
    }
}
