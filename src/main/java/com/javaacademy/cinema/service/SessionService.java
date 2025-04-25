package com.javaacademy.cinema.service;

import com.javaacademy.cinema.dto.PlaceDto;
import com.javaacademy.cinema.dto.SessionDto;
import com.javaacademy.cinema.dto.TicketDto;
import com.javaacademy.cinema.entity.Session;
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
    private final PlaceService placeService;
    private final TicketService ticketService;

    /*
    Просмотр всех сеансов
    */
    public List<SessionDto> selectAll() {
        List<SessionDto> result = sessionRepository.selectAll().stream()
                .map(entity -> sessionMapper.mapToDto(entity))
                .toList();
        return result;
    }

    /*
    Создание сеанса
    */
    public SessionDto save(SessionDto sessionDto) {
        Session session = sessionRepository.save(sessionMapper.mapToEntity(sessionDto));
        List<PlaceDto> places = placeService.selectAll();
        ticketService.createNewTickets(session);
        return sessionMapper.mapToDto(session);
    }

    public List<String> findFreeSeatsForSession(Integer sessionId) {
        List<TicketDto> tickets = ticketService.findFreeTickets(sessionId);
        return tickets.stream()
                .map(ticket -> ticket.getPlace().getSeatNumber())
                .toList();
    }

}
