package com.example.backend.seat_reservation;


public class seat_reservation {
    private int idSeat;
    private String time;
    private int movie_id;
    private int idSalon;
    private int seats_id;
    private Byte reserved;

    public seat_reservation(int idSeat, String time, int movie_id, int idSalon, int seats_id, Byte reserved) {
        this.idSeat = idSeat;
        this.time = time;
        this.movie_id = movie_id;
        this.idSalon = idSalon;
        this.seats_id = seats_id;
        this.reserved = reserved;
    }

    public int getIdSeat() {
        return idSeat;
    }

    public void setIdSeat(int idSeat) {
        this.idSeat = idSeat;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
    }

    public int getIdSalon() {
        return idSalon;
    }

    public void setIdSalon(int idSalon) {
        this.idSalon = idSalon;
    }

    public int getSeats_id() {
        return seats_id;
    }

    public void setSeats_id(int seats_id) {
        this.seats_id = seats_id;
    }

    public Byte getReserved() {
        return reserved;
    }

    public void setReserved(Byte reserved) {
        this.reserved = reserved;
    }

    @Override
    public String toString() {
        return "seat_reservation{" +
                "idSeat=" + idSeat +
                ", time='" + time + '\'' +
                ", movie_id=" + movie_id +
                ", idSalon=" + idSalon +
                ", seats_id=" + seats_id +
                ", reserved=" + reserved +
                '}';
    }
}
