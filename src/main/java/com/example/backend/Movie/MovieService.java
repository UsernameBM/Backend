package com.example.backend.Movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MovieService {

    @Autowired
    MovieDao movieDao;
    Movie movie;
    ArrayList<Movie> movies;

    public void insertMovie(String name, String description, String length){
        movieDao.insertMovie(name, description, length);
    }

    public void deleteMovie(int id){
        movieDao.deleteMovie(id);
    }

    public Movie getMovieById(int id){
        return movie = movieDao.getMovieById(id);
    }

    public ArrayList<Movie> getAllMovieById() {
        movies = movieDao.getAllMovieById();
        return  movies;
    }


    public void updateMovie(String name, String description, String length, int id){
        movieDao.updateMovie(name, description, length, id);
    }
}
