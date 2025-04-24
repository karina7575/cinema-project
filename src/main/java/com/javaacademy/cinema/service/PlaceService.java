package com.javaacademy.cinema.service;

import com.javaacademy.cinema.dto.PlaceDto;
import com.javaacademy.cinema.mapper.PlaceMapper;
import com.javaacademy.cinema.repository.PlaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PlaceService {
    private final PlaceRepository placeRepository;
    private final PlaceMapper placeMapper;

    public List<PlaceDto> selectAll() {
        List<PlaceDto> result = placeRepository.selectAll().stream()
                .map(entity -> placeMapper.mapToDto(entity))
                .toList();
        return result;
    }


}
