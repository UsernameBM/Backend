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
       String query = "SELECT * FROM movie.personal WHERE user_name= ?";

       Personal personal = jdbcTemplate.queryForObject(query, new RowMapper<Personal>() {
           @Override
           public Personal mapRow(ResultSet rs, int rowNum) throws SQLException {
               Personal per = new Personal(rs.getInt("idUser"),
                       rs.getString("firstname"),
                       rs.getString("lastname"),
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

   public void insertPersonal(String firstname, String lastname, String tel_number, String email, String bank, String banknumber,String user_name,String password, String Cinema_name){
       String query = "INSERT INTO personal (firstname, lastname, tel_number, email, bank, banknumber, user_name, password, Cinema_name) VALUES(?,?,?,?,?,?,?)";

       int result = jdbcTemplate.update(query, firstname, lastname, tel_number, email, bank, banknumber, user_name ,password, Cinema_name);
       if (result > 0) {
           System.out.println(result + " personal has been added!");
       }
   }

   public Personal verifyUsername(String user_name){
       String query = "SELECT * FROM personal WHERE user_name = ?";

       Personal personal = jdbcTemplate.queryForObject(query, new RowMapper<Personal>() {
           @Override
           public Personal mapRow(ResultSet rs, int rowNum) throws SQLException {
               Personal per = new Personal(rs.getInt("idUser"),
                       rs.getString("firstname"),
                       rs.getString("lastname"),
                       rs.getString("tel_number"),
                       rs.getString("email"),
                       rs.getString("bank"),
                       rs.getString("banknumber"),
                       rs.getString("user_name"),
                       rs.getString("password"),
                       rs.getString("Cinema_name"));
               return per;
           }
       }, user_name);
       return personal;
   }

   public void updatePersonal(String firstname, String lastname, String tel_number, String email, String bank, String banknumber, String user_name, String password, String Cinema_name, int idUser){
       String query = "UPDATE personal SET firstname =?, lastname =?, tel_number =?, email =?, bank =?, banknumber =?, user_name =?, password =?, Cinema_name =? WHERE (idUser =?)";

       int result = jdbcTemplate.update(query, firstname, lastname, tel_number, email, bank, banknumber, user_name, password, Cinema_name, idUser);

       if (result > 0){
           System.out.println(result + " personal has been updated!");
       }
   }

}