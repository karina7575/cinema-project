package com.javaacademy.cinema.repository;

import com.javaacademy.cinema.entity.Session;
import com.javaacademy.cinema.entity.Ticket;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class TicketRepository {
    private final JdbcTemplate jdbcTemplate;
    private final SessionRepository sessionRepository;
    private final PlaceRepository placeRepository;

    /*
    Поиск билета по id
     */
    public Optional<Ticket> findById(Integer id) {
        String sql = "SELECT * FROM ticket WHERE id = ?";
        try {
            return Optional.of(jdbcTemplate.queryForObject(sql, this::mapToTicket, id));
        }
        catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    /*
    Преобразование строки из БД в объект класса Ticket
    */
    private Ticket mapToTicket(ResultSet rs, int rowNum) throws SQLException {
        Ticket ticket = new Ticket();
        ticket.setId(rs.getInt("id"));

        if(rs.getString("seat_id") != null) {
            Integer seatId = Integer.valueOf(rs.getString("seat_id"));
            ticket.setPlace(placeRepository.findById(seatId).orElse(null));
        }

        if(rs.getString("session_id") != null) {
            Integer sessionId = Integer.valueOf(rs.getString("session_id"));
            ticket.setSession(sessionRepository.findById(sessionId).orElse(null));
        }

        ticket.setBuyed(rs.getBoolean("is_buyed"));

        return ticket;
    }

    /*
    Сохранение билета в БД
    */
    public Ticket save(Ticket ticket) {
        String sql = "INSERT INTO ticket (seat_id, session_id, is_buyed) values (?, ?, ?) returning id;";
        Integer ticketId = jdbcTemplate.queryForObject(sql, Integer.class,ticket.getPlace().getId(), ticket.getSession().getId(), false);
        ticket.setId(ticketId);
        return ticket;
    }

    /*
    Смена статуса билета в БД на "куплен"
    */
    public Ticket save(Ticket ticket) {
        String sql = "INSERT INTO ticket (seat_id, session_id, is_buyed) values (?, ?, ?) returning id;";
        Integer ticketId = jdbcTemplate.queryForObject(sql, Integer.class,ticket.getPlace().getId(), ticket.getSession().getId(), false);
        ticket.setId(ticketId);
        return ticket;
    }
}
