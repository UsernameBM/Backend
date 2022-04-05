package com.example.backend.Salon;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalonService {

    @Autowired
    SalonDao salonDao;

    public void insertSalon (Salon salon){

        salonDao.insertSalon(salon.getSeats(), salon.getRow(), salon.getCinemaName());
    }

    public Salon getSalonById(String id){
        Salon salon = salonDao.getSalonById(id);
        return salon;
    }

}
