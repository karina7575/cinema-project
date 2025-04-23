package com.javaacademy.cinema.entity;

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
public class Session {
    private Integer id;
    private LocalDateTime movieDate;
    private BigDecimal price;
    private Movie movie;
}
