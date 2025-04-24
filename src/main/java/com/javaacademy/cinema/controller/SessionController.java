package com.javaacademy.cinema.controller;

import com.javaacademy.cinema.dto.SessionDto;
import com.javaacademy.cinema.service.PlaceService;
import com.javaacademy.cinema.service.SessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/session")
@RequiredArgsConstructor
public class SessionController {
    private final SessionService sessionService;

    /*
    Создание сеанса (для администратора)
    */
    @PostMapping
    public SessionDto createSession(SessionDto sessionDto) {
        return sessionService.save(sessionDto);
    }

    /*
    Получение всех сеансов (для посетителя)
    */
    @GetMapping
    public List<SessionDto> findAll() {
        sessionService.selectAll();
    }
}
