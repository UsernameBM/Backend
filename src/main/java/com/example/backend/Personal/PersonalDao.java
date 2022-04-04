package com.example.backend.Personal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class PersonalDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

   public Personal getPersonalByUsername(String user_name){
       String query = "SELECT * FROM personal WHERE user_name= ?";

       Personal personal = jdbcTemplate.queryForObject(query, new RowMapper<Personal>() {
           @Override
           public Personal mapRow(ResultSet rs, int rowNum) throws SQLException {
               Personal per = new Personal(rs.getInt("idUser"),
                       rs.getString("tel_number"),
                       rs.getString("email"),
                       rs.getString("bank"),
                       rs.getString("banknumber"),
                       rs.getString("user_name"),
                       rs.getString("password"),
                       rs.getString("cinema_name"));
               return per;
           }
       }, user_name);
       return personal;
   }
}
