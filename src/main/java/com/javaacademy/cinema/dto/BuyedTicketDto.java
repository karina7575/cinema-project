package com.javaacademy.cinema.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BuyedTicketDto {
    @JsonProperty("ticket_id")
    private Integer id;
    @JsonProperty("place_name")
    private String placeName;
    @JsonProperty("movie_name")
    private String movie_name;
    private LocalDateTime date;
}
