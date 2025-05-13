package com.javaacademy.cinema.controller;

import com.javaacademy.cinema.dto.BuyedTicketDto;
import com.javaacademy.cinema.dto.Dto;
import com.javaacademy.cinema.dto.TicketDto;
import com.javaacademy.cinema.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ticket")
@RequiredArgsConstructor
public class TicketController {
    private final TicketService ticketService;

    /*
    Получение всех купленных билетов (для администратора)
    */
    @GetMapping("/saled")
    public List<TicketDto> findAllSaledTickets() {
        return ticketService.findAllSaledTickets();
    }

    @PostMapping("/booking")
    public BuyedTicketDto buyTicket(@RequestBody Dto dto) {
        return ticketService.changeIsBuyed(dto);
    }
}
