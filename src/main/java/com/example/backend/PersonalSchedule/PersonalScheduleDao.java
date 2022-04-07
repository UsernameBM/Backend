package com.example.backend.PersonalSchedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class PersonalScheduleDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public ArrayList<PersonalSchedule> getAllPersonalSchedule(){
        String query = "SELECT * FROM personalschedule";
        ArrayList<PersonalSchedule> personalSchedules = new ArrayList<>();
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(query);

        for (Map<String, Object> row : rows) {
            PersonalSchedule personalSchedule = new PersonalSchedule(
                    String.valueOf(row.get("date")),
                    (int)row.get("idUser"),
                    (int)row.get("idSalon"),
                    String.valueOf(row.get("Kassa")),
                    String.valueOf(row.get("Kitchen")));
            personalSchedules.add(personalSchedule);
        }
        return personalSchedules;
    }

    public void insertPersonalSchedule(String date, int idUser, int idSalon, String Kassa, String Kitchen) {
        String query = "INSERT INTO personalschedule (date, idUser, idSalon, Kassa, Kitchen) VALUES(?,?,?,?,?)";

        int result = jdbcTemplate.update(query, date, idUser, idSalon, Kassa, Kitchen);

        if (result > 0) {
            System.out.println(result + " schedule has been added!");
        }
    }
}