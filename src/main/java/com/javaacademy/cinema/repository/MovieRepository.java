package com.javaacademy.cinema.repository;

import com.javaacademy.cinema.dto.MovieDto;
import com.javaacademy.cinema.entity.Movie;
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
public class MovieRepository {
    private final JdbcTemplate jdbcTemplate;

    /*
    Все фильмы
     */
    public List<Movie> selectAll() {
        String sql = "SELECT * FROM movie";
        List<Movie> result = jdbcTemplate.query(sql, this::mapToMovie);
        return result;
    }

    /*
    Преобразование строки из БД в объект класса Movie
    */
    private Movie mapToMovie(ResultSet rs, int rowNum) throws SQLException {
        Movie movie = new Movie();
        movie.setId(rs.getInt("id"));
        movie.setMovieName(rs.getString("movie_name"));
        movie.setMovieDescription(rs.getString("movie_description"));
        return movie;
    }

    /*
    Сохранение фильма в БД
     */
    public Movie save(Movie movie) {
        String sql = "INSERT INTO movie (movie_name, movie_description) values (?, ?) returning id;";
//        Integer movieId = jdbcTemplate.update(sql, ps -> {
//            ps.setString(1, movie.getMovieName());
//            ps.setString(2, movie.getMovieDescription());
//        });
        Integer movieId = jdbcTemplate.queryForObject(sql, Integer.class, movie.getMovieName(), movie.getMovieDescription());
        movie.setId(movieId);
        return movie;
    }

    /*
    Поиск фильма по id
     */
    public Optional<Movie> findById(Integer id) {
        String sql = "SELECT * FROM movie WHERE id = ?";
        try {
            return Optional.of(jdbcTemplate.queryForObject(sql, this::mapToMovie, id));
        }
        catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

}
