package com.example.backend.Movie;

public class Movie {
    private int id;
    private String name;
    private String description;
    private String length;

    public Movie(int id, String name, String description, String length) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.length = length;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }
}
