package com.javaacademy.cinema.repository;

import com.javaacademy.cinema.entity.Place;
import com.javaacademy.cinema.entity.Session;
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
public class PlaceRepository {
    private final JdbcTemplate jdbcTemplate;

    /*
    Поиск места по id
     */
    public Optional<Place> findById(Integer id) {
        String sql = "SELECT * FROM seat WHERE id = ?";
        try {
            return Optional.of(jdbcTemplate.queryForObject(sql, this::mapToPlace, id));
        }
        catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }
    /*
    Преобразование строки из БД в объект класса Place
    */
    private Place mapToPlace(ResultSet rs, int rowNum) throws SQLException {
        Place place = new Place();
        place.setId(rs.getInt("id"));
        place.setSeatNumber(rs.getString("seat_number"));
        return place;
    }

    /*
    Все места
    */
    public List<Place> selectAll() {
        String sql = "SELECT * FROM seat";
        List<Place> result = jdbcTemplate.query(sql, this::mapToPlace);
        return result;
    }


}
