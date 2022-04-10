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

    public void insertPersonal(String firstname, String lastname, String tel_number, String email, String bank, String banknumber, String user_name ,String password, String Cinema_name){
        personalDao.insertPersonal(firstname, lastname, tel_number, email, bank, banknumber, user_name,password, Cinema_name);
    }

    public Personal verifyUsername(String user_name){
        personal = personalDao.verifyUsername(user_name);
        return personal;
    }

    public void updatePersonal(String firstname, String lastname, String tel_number, String email, String bank, String banknumber, String user_name, String password, String Cinema_name, int idUser){
        personalDao.updatePersonal(firstname, lastname, tel_number, email, bank, banknumber, user_name, password, Cinema_name, idUser);
    }
}
