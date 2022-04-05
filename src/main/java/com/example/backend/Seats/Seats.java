package com.example.backend.Seats;

public class Seats {
    private int id;
    private int seat;
    private int row;
    private int idSalon;
    private String cinema_name;

    public Seats(int id, int seat, int row, int idSalon, String cinema_name) {
        this.id = id;
        this.seat = seat;
        this.row = row;
        this.idSalon = idSalon;
        this.cinema_name = cinema_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getIdSalon() {
        return idSalon;
    }

    public void setIdSalon(int idSalon) {
        this.idSalon = idSalon;
    }

    public String getCinema_name() {
        return cinema_name;
    }

    public void setCinema_name(String cinema_name) {
        this.cinema_name = cinema_name;
    }

    @Override
    public String toString() {
        return "Seats{" +
                "id=" + id +
                ", seat=" + seat +
                ", row=" + row +
                ", idSalon=" + idSalon +
                ", cinema_name='" + cinema_name + '\'' +
                '}';
    }
}
