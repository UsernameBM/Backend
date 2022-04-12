package com.example.backend.Salon;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class SalonService {

    @Autowired
    SalonDao salonDao;
    ArrayList<Salon> salons;

    public String insertSalon (Salon salon){

        String salonAdded = "Your Salon has been added to the database with following Salon information: ";
        salonDao.insertSalon(salon.getSeats(), salon.getRow(), salon.getCinemaName());
        return salonAdded + " " + salon.getSeats() + " " + salon.getRow() + " " + salon.getCinemaName();

    }

    public Salon getSalonById(String id){
        Salon salon = salonDao.getSalonById(id);
        return salon;
    }

    public ArrayList<Salon> getAllSalons(){
        salons = salonDao.getAllSalons();
        return salons;
    }

}
