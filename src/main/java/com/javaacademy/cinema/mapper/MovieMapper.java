package com.javaacademy.cinema.mapper;

import com.javaacademy.cinema.dto.AdminMovieDto;
import com.javaacademy.cinema.dto.MovieDto;
import com.javaacademy.cinema.entity.Movie;
import org.springframework.stereotype.Service;

@Service
public class MovieMapper {

    public MovieDto mapToDto(Movie movie) {
        return new MovieDto(movie.getId(), movie.getMovieName(), movie.getMovieDescription());
    }

    public AdminMovieDto mapToAdminDto(Movie movie) {
        return new AdminMovieDto(movie.getId(), movie.getMovieName(), movie.getMovieDescription());
    }

    public Movie mapToEntity(MovieDto movieDto) {
        return new Movie(movieDto.getId(), movieDto.getMovieName(), movieDto.getMovieDescription());
    }


}
