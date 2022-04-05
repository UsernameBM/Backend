package com.example.backend.Screening;

import java.sql.Time;


public class Screening {


    private Time time;
    private int movieId;
    private int idSalon;


    public Screening(Time time, int movieId, int idSalon){
        this.time = time;
        this.movieId = movieId;
        this.idSalon = idSalon;
    }

    public int getIdSalon() {
        return idSalon;
    }

    public void setIdSalon(int idSalon) {
        this.idSalon = idSalon;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    @Override
    public String toString() {
        return "com.example.backend.Screening{" +
                "idSalon=" + idSalon +
                ", time=" + time +
                ", movieId=" + movieId +
                '}';
    }
}
