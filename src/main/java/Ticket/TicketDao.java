package Ticket;

import Customer.Customer;
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
    }