package com.javaacademy.cinema.repository;

import com.javaacademy.cinema.entity.Movie;
import com.javaacademy.cinema.entity.Session;
import com.javaacademy.cinema.entity.Ticket;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class SessionRepository {
    private final JdbcTemplate jdbcTemplate;
    private final MovieRepository movieRepository;

    /*
    Поиск сеанса по id
     */
    public Optional<Session> findById(Integer id) {
        String sql = "SELECT * FROM movie_session WHERE id = ?";
        try {
            return Optional.of(jdbcTemplate.queryForObject(sql, this::mapToSession, id));
        }
        catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    /*
    Преобразование строки из БД в объект класса Session
    */
    private Session mapToSession(ResultSet rs, int rowNum) throws SQLException {
        Session session = new Session();
        session.setId(rs.getInt("id"));
        session.setMovieDate(rs.getTimestamp("movie_date").toLocalDateTime());
        session.setPrice(rs.getBigDecimal("price"));
        if (rs.getString("movie_id") != null) {
            Integer movieId = Integer.valueOf(rs.getString("movie_id"));
            session.setMovie(movieRepository.findById(movieId).orElse(null));
        }
        return session;
    }

    /*
    Все сеансы
    */
    public List<Session> selectAll() {
        String sql = "SELECT * FROM movie_session";
        List<Session> result = jdbcTemplate.query(sql, this::mapToSession);
        return result;
    }

    /*
    Сохранение сеанса в БД
    */
    public Session save(Session session) {
        String sql = "INSERT INTO movie_session (movie_id, movie_date, price) values (?, ?, ?) returning id;";
        Integer sessionId = jdbcTemplate.queryForObject(sql, Integer.class,session.getMovie().getId(), session.getMovieDate(), session.getPrice());
        session.setId(sessionId);
        return session;
    }
}
