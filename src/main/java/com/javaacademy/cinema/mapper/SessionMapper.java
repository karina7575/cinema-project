package com.javaacademy.cinema.mapper;

import com.javaacademy.cinema.dto.SessionDto;
import com.javaacademy.cinema.entity.Session;
import org.springframework.stereotype.Service;

@Service
public class SessionMapper {
    public SessionDto mapToDto(Session session) {
        return new SessionDto(session.getId(), session.getMovieDate(), session.getPrice(), session.getMovie());
    }

    public Session mapToEntity(SessionDto sessionDto) {
        return new Session(sessionDto.getId(), sessionDto.getMovieDate(), sessionDto.getPrice(), sessionDto.getMovie());
    }
}
