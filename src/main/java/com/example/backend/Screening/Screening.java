package com.example.backend.Screening;

import java.sql.Time;


public class Screening {


    private String time;
    private int movieId;
    private int idSalon;


    public Screening(String time, int movieId, int idSalon) {
        this.time = time;
        this.movieId = movieId;
        this.idSalon = idSalon;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public int getIdSalon() {
        return idSalon;
    }

    public void setIdSalon(int idSalon) {
        this.idSalon = idSalon;
    }

    @Override
    public String toString() {
        return "Screening{" +
                "time='" + time + '\'' +
                ", movieId=" + movieId +
                ", idSalon=" + idSalon +
                '}';
    }
}


