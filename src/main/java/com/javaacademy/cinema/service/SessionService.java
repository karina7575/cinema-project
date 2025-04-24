package com.javaacademy.cinema.service;

import com.javaacademy.cinema.dto.SessionDto;
import com.javaacademy.cinema.mapper.SessionMapper;
import com.javaacademy.cinema.repository.SessionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SessionService {
    private final SessionRepository sessionRepository;
    private final SessionMapper sessionMapper;

    public List<SessionDto> selectAll() {
        List<SessionDto> result = sessionRepository.selectAll().stream()
                .map(entity -> sessionMapper.mapToDto(entity))
                .toList();
        return result;
    }

    public void save(SessionDto sessionDto) {
        sessionRepository.save(sessionMapper.mapToEntity(sessionDto));
    }
}
