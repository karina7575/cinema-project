package com.javaacademy.cinema.service;

import com.javaacademy.cinema.dto.BuyedTicketDto;
import com.javaacademy.cinema.dto.Dto;
import com.javaacademy.cinema.dto.TicketDto;
import com.javaacademy.cinema.entity.Place;
import com.javaacademy.cinema.entity.Session;
import com.javaacademy.cinema.entity.Ticket;
import com.javaacademy.cinema.mapper.TicketMapper;
import com.javaacademy.cinema.repository.PlaceRepository;
import com.javaacademy.cinema.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

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
    Получение списка некупленных билетов для сеанса
    */
    public List<TicketDto> findFreeTickets(Integer sessionId) {
        List<TicketDto> result = ticketRepository.findFreeTickets(sessionId).stream()
                .map(entity -> ticketMapper.mapToDto(entity))
                .toList();
        return result;
    }

    /*
    Получение списка всех купленных билетов
    */
    public List<TicketDto> findAllSaledTickets() {
        List<TicketDto> result = ticketRepository.findAllTakenTickets().stream()
                .map(entity -> ticketMapper.mapToDto(entity))
                .toList();
        return result;
    }

    /*
    Смена статуса билета на "куплен"
    */
    public BuyedTicketDto changeIsBuyed(@RequestBody Dto dto) {
        //надо найти айди билета
        List<Ticket> tickets = ticketRepository.findFreeTickets(dto.getSessionId());
        if(tickets.isEmpty()){
            //что-то плохое, нет свободных билетов
        }
        else {
            for(int i = 0; i < tickets.size(); i++) {
                if(tickets.get(i).getPlace().getSeatNumber().equals("A1")) {
                    ticketRepository.changeIsBuyed(tickets.get(i).getId());
                    BuyedTicketDto buyedTicket= ticketMapper.mapToBuyedDto(ticketRepository.findById(i).get());
                    return buyedTicket;
                }
            }
        }

        try {
            ticketRepository.changeIsBuyed(id);
            return true;
        }
        catch (RuntimeException e) {
            return false;
        }
    }
}
