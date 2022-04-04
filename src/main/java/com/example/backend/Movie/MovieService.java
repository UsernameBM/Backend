package com.example.backend.Movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    @Autowired
    MovieDao movieDao;
    Movie movie;

    public void insertMovie(String name, String image, String description, String length){
        movieDao.insertMovie(name, image, description, length);
    }

    public void deleteMovie(int id){
        movieDao.deleteMovie(id);
    }

    public Movie getMovieById(int id){
        return movie = movieDao.getMovieById(id);
    }

    public void updateMovie(String name, String image, String description, String length, int id){
        movieDao.updateMovie(name, image, description, length, id);
    }
}
