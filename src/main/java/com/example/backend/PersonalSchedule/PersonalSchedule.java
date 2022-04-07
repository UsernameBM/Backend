package com.example.backend.PersonalSchedule;

public class PersonalSchedule {
    private String date;
    private int idUser;
    private int idSalon;
    private String Kassa;
    private String Kitchen;

    public PersonalSchedule(String date, int idUser, int idSalon, String kassa, String kitchen) {
        this.date = date;
        this.idUser = idUser;
        this.idSalon = idSalon;
        Kassa = kassa;
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

    public String getKassa() {
        return Kassa;
    }

    public void setKassa(String kassa) {
        Kassa = kassa;
    }

    public String getKitchen() {
        return Kitchen;
    }

    public void setKitchen(String kitchen) {
        Kitchen = kitchen;
    }
}
