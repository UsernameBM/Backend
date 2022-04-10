package com.example.backend.PersonalSchedule;

public class PersonalSchedule {
    private String date;
    private int idUser;
    private int idSalon;
    private String Counter;
    private String Kitchen;

    public PersonalSchedule(String date, int idUser, int idSalon, String Counter, String kitchen) {
        this.date = date;
        this.idUser = idUser;
        this.idSalon = idSalon;
        this.Counter = Counter;
        Kitchen = kitchen;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdSalon() {
        return idSalon;
    }

    public void setIdSalon(int idSalon) {
        this.idSalon = idSalon;
    }

    public String getCounter() {
        return Counter;
    }

    public void setCounter(String counter) {
        Counter = counter;
    }

    public String getKitchen() {
        return Kitchen;
    }

    public void setKitchen(String kitchen) {
        Kitchen = kitchen;
    }
}
