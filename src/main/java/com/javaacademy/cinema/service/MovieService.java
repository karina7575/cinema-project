package com.javaacademy.cinema.service;

import com.javaacademy.cinema.dto.MovieDto;
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

    public void save(MovieDto movieDto) {
        movieRepository.save(movieMapper.mapToEntity(movieDto));
    }


}
