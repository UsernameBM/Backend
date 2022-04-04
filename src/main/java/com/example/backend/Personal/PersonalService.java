package com.example.backend.Personal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonalService {

    @Autowired
    PersonalDao personalDao;
    Personal personal;

    public Personal getPersonalByUsername(String user_name){
        return personal = personalDao.getPersonalByUsername(user_name);
    }
}
