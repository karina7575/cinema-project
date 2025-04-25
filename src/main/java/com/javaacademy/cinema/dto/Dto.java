package com.javaacademy.cinema.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Dto {
    @JsonProperty("session_id")
    private Integer sessionId;
    @JsonProperty("place_name")
    private String placeNumber;
}
