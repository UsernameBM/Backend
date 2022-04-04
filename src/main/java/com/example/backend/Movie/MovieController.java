package com.example.backend.Movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {

    @Autowired
    MovieService movieService;

    public MovieController(MovieService movieService){
        this.movieService = movieService;
    }

    @GetMapping("/insertMovie")
    public void insertMovie(@RequestParam(value = "name", defaultValue = "No name")String name,
                            @RequestParam(value = "image", defaultValue = "No image")String image,
                            @RequestParam(value = "description", defaultValue = "No description")String description,
                            @RequestParam(value = "length", defaultValue = "No length")String length){
        movieService.insertMovie(name, image, description, length);
    }

    @GetMapping("/deleteMovie")
    public void deleteMovie(@RequestParam(value = "id", defaultValue = "-1")int id){
        movieService.deleteMovie(id);
    }

    @GetMapping("/getMovieById")
    public Movie getMovieById(@RequestParam(value = "id", defaultValue = "0")int id){
        return movieService.getMovieById(id);
    }

    @GetMapping("/updateMovie")
    public void updateMovie(@RequestParam(value = "name", defaultValue = "No name")String name,
                            @RequestParam(value = "image", defaultValue = "No image")String image,
                            @RequestParam(value = "description", defaultValue = "No description")String description,
                            @RequestParam(value = "length", defaultValue = "No length")String length,
                            @RequestParam(value = "id", defaultValue = "0")int id){
        movieService.updateMovie(name, image, description, length, id);
    }
    //Hej
}
