package com.javaacademy.cinema.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.javaacademy.cinema.entity.Movie;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SessionDto {
    private Integer id;
    @JsonProperty("movie_date")
    private LocalDateTime movieDate;
    @JsonProperty("price")
    private BigDecimal price;
    @JsonProperty("movie")
    private Movie movie;
}
