package com.example.backend.Screening;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class ScreeningDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insertScreening(String time, int movieId, int idSalon){

        String query = "INSERT INTO screening (time, movie_id, idSalon) VALUES(?,?,?)";

        int result = jdbcTemplate.update(query,time, movieId, idSalon);

        if(result > 0) {
            System.out.println(result + "a screening has been added to the database");
        }
    }
       public Screening getScreeningById(String id){
        String query = "SELECT * FROM screening WHERE idSalon =?";

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

    public ArrayList<Screening> getAllScreening(){
        String query = "SELECT * FROM screening";
        ArrayList<Screening> screenings = new ArrayList<>();
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(query);

        for (Map<String, Object> row : rows){
            Screening screening = new Screening(String.valueOf(row.get("time")),
                    (int) row.get("movie_id"),
                    (int) row.get("idSalon"));
            screenings.add(screening);
        }
        return screenings;
    }
}
