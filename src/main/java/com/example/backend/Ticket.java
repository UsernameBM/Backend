package com.example.backend;

public class Ticket {
    private int idTicket;
    private double price;
    private int custumer_id;
    private int idSeat;
    private String time;
    private int movie_id;
    private int idSalon;
    private int seats_id;

    @Override
    public String toString() {
        return "Ticket{" +
                "idTicket=" + idTicket +
                ", price=" + price +
                ", custumer_id=" + custumer_id +
                ", idSeat=" + idSeat +
                ", time='" + time + '\'' +
                ", movie_id=" + movie_id +
                ", idSalon=" + idSalon +
                ", seats_id=" + seats_id +
                '}';
    }

    public int getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(int idTicket) {
        this.idTicket = idTicket;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCustumer_id() {
        return custumer_id;
    }

    public void setCustumer_id(int custumer_id) {
        this.custumer_id = custumer_id;
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
}
