package com.javaacademy.cinema.controller;

import com.javaacademy.cinema.dto.MovieDto;
import com.javaacademy.cinema.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movie")
@RequiredArgsConstructor
public class MovieController {
    private final MovieService movieService;

    /*
    Создание нового фильма (для администратора)
    */
    @PostMapping
    public MovieDto save(MovieDto movieDto) {
        return movieService.save(movieDto);
    }

    /*
    Получение всех фильмов, которые идут (для посетителя)
    */
    @GetMapping
    public List<MovieDto> findAll() {
        return movieService.selectAll();
    }

}
