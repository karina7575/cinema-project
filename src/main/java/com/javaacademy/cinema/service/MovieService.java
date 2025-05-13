package com.javaacademy.cinema.service;

import com.javaacademy.cinema.dto.AdminMovieDto;
import com.javaacademy.cinema.dto.MovieDto;
import com.javaacademy.cinema.entity.Movie;
import com.javaacademy.cinema.mapper.MovieMapper;
import com.javaacademy.cinema.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {
    private final MovieRepository movieRepository;
    private final MovieMapper movieMapper;

    public List<MovieDto> selectAll() {
        List<MovieDto> result = movieRepository.selectAll().stream()
                                                            .map(entity -> movieMapper.mapToDto(entity))
                                                            .toList();
        return result;
    }

    public AdminMovieDto save(MovieDto movieDto) {
        Movie movie = movieRepository.save(movieMapper.mapToEntity(movieDto));
        return movieMapper.mapToAdminDto(movie);
    }


}
