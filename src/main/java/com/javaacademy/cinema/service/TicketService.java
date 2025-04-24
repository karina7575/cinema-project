package com.javaacademy.cinema.service;

import com.javaacademy.cinema.dto.TicketDto;
import com.javaacademy.cinema.entity.Place;
import com.javaacademy.cinema.entity.Session;
import com.javaacademy.cinema.entity.Ticket;
import com.javaacademy.cinema.mapper.TicketMapper;
import com.javaacademy.cinema.repository.PlaceRepository;
import com.javaacademy.cinema.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TicketService {
    private final TicketRepository ticketRepository;
    private final TicketMapper ticketMapper;
    private final PlaceRepository placeRepository;

    /*
    Создание некупленных билетов для сеанса
    */
    public void createNewTickets(Session session) {
        List<Place> listPlaces = placeRepository.selectAll();
        for(int i = 0; i < listPlaces.size(); i++) {
            Ticket ticket = Ticket.builder()
                    .session(session)
                    .place(listPlaces.get(i))
                    .isBuyed(false)
                    .build();
            ticketRepository.save(ticket);
        }
    }

    /*
    Получение списка купленных билетов для сеанса
    */
    public List<TicketDto> findSaledTickets(Integer sessionId) {
        List<TicketDto> result = ticketRepository.findTakenTickets(sessionId).stream()
                .map(entity -> ticketMapper.mapToDto(entity))
                .toList();
        return result;
    }

    /*
    Смена статуса билета на "куплен"
    */
    public boolean changeIsBuyed(Integer id) {
        try {
            ticketRepository.changeIsBuyed(id);
            return true;
        }
        catch (RuntimeException e) {
            return false;
        }
    }
}
