package com.javaacademy.cinema.dto;

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
    private LocalDateTime movieDate;
    private BigDecimal price;
    private Movie movie;
}
