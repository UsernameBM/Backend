package com.example.backend.Ticket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class TicketDao {

        @Autowired
        private JdbcTemplate jdbcTemplate;

        public Ticket getTicketByCustomerId(int costumer_id) {
            String query = "SELECT * FROM movie.ticket WHERE costumer_id = ?";

            Ticket ticket = jdbcTemplate.queryForObject(query, new RowMapper<Ticket>() {
                @Override
                public Ticket mapRow(ResultSet rs, int rowNum) throws SQLException {
                    Ticket tic = new Ticket(rs.getInt("idTicket"),
                            rs.getDouble("price"),
                            rs.getInt("costumer_id"),
                            rs.getInt("idSeat"),
                            rs.getString("time"),
                            rs.getInt("movie_id"),
                            rs.getInt("idSalon"),
                            rs.getInt("seats_id"));
                    return tic;
                }
            }, costumer_id);

            return ticket;

        }


        public void insertTicket(double price, int ticket_amount, int costumer_id, int idSeat, String time, int movie_id, int idSalon, int seats_id){
            String query = "INSERT INTO ticket (price, ticket_amount, costumer_id, idSeat, time, movie_id, idSalon, seats_id, reserved) VALUES(?,?,?,?,?,?,?,?)";

            int result = jdbcTemplate.update(query, price, ticket_amount, costumer_id, idSeat, time, movie_id, idSalon, seats_id);

            if (result > 0){
                System.out.println(result + " Ticket has been added!");
            }

        }


        public void deleteTicket(int idTicket){
            String query = "DELETE FROM ticket WHERE idTicket = ?";

            int result = jdbcTemplate.update(query, idTicket);

            if (result > 0){
                System.out.println(result + "this ticket is deleted");
            }
        }

    }