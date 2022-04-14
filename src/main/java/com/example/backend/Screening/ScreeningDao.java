package com.example.backend.Screening;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;

@Repository
public class ScreeningDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insertScreening(String time, int movieId, int idSalon){

        String query = "INSERT INTO movie.screening (time, movie_id, idSalon) VALUES(?,?,?)";

        int result = jdbcTemplate.update(query,time, movieId, idSalon);

        if(result > 0) {
            System.out.println(result + "a screening has been added to the database");
        }
    }
       public Screening getScreeningById(String id){
        String query = "SELECT * FROM movie.screening WHERE idSalon =?";

        Screening screening = jdbcTemplate.queryForObject(query, new RowMapper<Screening>() {
            @Override
            public Screening mapRow(ResultSet rs, int rowNum) throws SQLException {
                Screening screen = new Screening (rs.getString("time"),
                        rs.getInt("movie_id"),
                        rs.getInt("idSalon")
                        );
                return screen;
            }
        },id);

        return screening;

}
}
