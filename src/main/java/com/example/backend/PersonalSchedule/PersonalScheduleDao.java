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
                    (int)row.get("id"),
                    String.valueOf(row.get("date")),
                    (int)row.get("idUser"),
                    (int)row.get("idSalon"),
                    String.valueOf(row.get("Counter")),
                    String.valueOf(row.get("Kitchen")));
            personalSchedules.add(personalSchedule);
        }
        return personalSchedules;
    }

    public void insertPersonalSchedule(int idSalon, int idUser, String Counter, String Kitchen, String date) {
        String query = "INSERT INTO personalschedule (date, idUser, idSalon, Counter, Kitchen) VALUES(?,?,?,?,?)";

        int result = jdbcTemplate.update(query, idSalon, idUser,Counter, Kitchen ,date);

        if (result > 0) {
            System.out.println(result + " schedule has been added!");
        }
    }

    public void deleteSchedule(int id){
        String query = "DELETE FROM personalschedule WHERE id= ?";
        int result = jdbcTemplate.update(query, id);

        if (result > 0 ){
            System.out.println(result + " this schedule is deleted");
        }
    }
}
