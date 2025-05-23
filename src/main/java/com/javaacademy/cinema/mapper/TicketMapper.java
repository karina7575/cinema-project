package com.javaacademy.cinema.mapper;

import com.javaacademy.cinema.dto.BuyedTicketDto;
import com.javaacademy.cinema.dto.TicketDto;
import com.javaacademy.cinema.entity.Ticket;
import org.springframework.stereotype.Service;

@Service
public class TicketMapper {
    public TicketDto mapToDto(Ticket ticket) {
        return new TicketDto(ticket.getId(), ticket.getSession(), ticket.getPlace(), ticket.isBuyed());
    }

    public Ticket mapToEntity(TicketDto ticketDto) {
        return new Ticket(ticketDto.getId(), ticketDto.getSession(), ticketDto.getPlace(), ticketDto.isBuyed());
    }

    public BuyedTicketDto mapToBuyedDto(Ticket ticket) {
        return new BuyedTicketDto(ticket.getId(),
                                    ticket.getPlace().getSeatNumber(),
                                    ticket.getSession().getMovie().getMovieName(),
                                    ticket.getSession().getMovieDate());
    }
}
