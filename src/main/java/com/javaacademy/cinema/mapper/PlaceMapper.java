package com.javaacademy.cinema.mapper;

import com.javaacademy.cinema.dto.PlaceDto;
import com.javaacademy.cinema.entity.Place;
import org.springframework.stereotype.Service;

@Service
public class PlaceMapper {
    public PlaceDto mapToDto(Place place) {
        return new PlaceDto(place.getId(), place.getSeatNumber());
    }

    public Place mapToEntity(PlaceDto placeDto) {
        return new Place(placeDto.getId(), placeDto.getSeatNumber());
    }
}
