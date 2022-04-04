package com.example.backend.Movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class MovieDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insertMovie(String name, String image, String description, String length){
        String query = "INSERT INTO movie (name, image, description, length) VALUES(?,?,?,?)";

        int result = jdbcTemplate.update(query, name, image, description, length);

        if(result > 0){
            System.out.println(result + " movie has been added!");
        }
    }


    public void deleteMovie(int id){
        String query = "DELETE FROM movie WHERE id = ?";

        int result = jdbcTemplate.update(query,id);

        if(result > 0){
            System.out.println(result + " this movie is deleted!");
        }

    }

    public Movie getMovieById(int id){
        String query = "SELECT * FROM movie WHERE id= ?";

        Movie movie = jdbcTemplate.queryForObject(query, new RowMapper<Movie>() {
            @Override
            public Movie mapRow(ResultSet rs, int rowNum) throws SQLException {
                Movie mov = new Movie(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("image"),
                        rs.getString("description"),
                        rs.getString("length"));
                return mov;
            }
        }, id);
        return movie;
    }


    public void updateMovie(String name, String image, String description, String length, int id){
        String query = "UPDATE movie SET name =?, image =?, description =?, length =? WHERE (id =?)";

        int result = jdbcTemplate.update(query, name, image, description, length, id);

        if(result > 0){
            System.out.println(result + "movie has been updated!");
        }
    }
}
