package com.example.backend.Salon;

public class Salon {

    private int idSalon;
    private int seats;
    private int row;
    private String cinemaName;

    public Salon (int idSalon, int seats, int row, String cinemaName){
        this.idSalon = idSalon;
        this.seats = seats;
        this.row = row;
        this.cinemaName = cinemaName;
    }

    public int getIdSalon() {
        return idSalon;
    }

    public void setIdSalon(int idSalon) {
        this.idSalon = idSalon;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public String getCinemaName() {
        return cinemaName;
    }

    public void setCinemaName(String cinemaName) {
        this.cinemaName = cinemaName;
    }

    @Override
    public String toString() {
        return "com.example.backend.Salon{" +
                "idSalon=" + idSalon +
                ", seats=" + seats +
                ", row=" + row +
                ", cinemaName='" + cinemaName + '\'' +
                '}';
    }
}
