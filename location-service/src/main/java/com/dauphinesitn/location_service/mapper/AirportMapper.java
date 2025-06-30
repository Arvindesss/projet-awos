package com.dauphinesitn.location_service.mapper;

import com.dauphinesitn.location_service.dto.AirportDTO;
import com.dauphinesitn.location_service.dto.AirportDTOResponse;
import com.dauphinesitn.location_service.model.Airport;

import java.util.List;

public class AirportMapper {

    public static AirportDTO toDTO(Airport airport){
        return AirportDTO.builder()
                .airportId(airport.getAirportId())
                .name(airport.getName())
                .cityId(airport.getCity().getUuid())
                .build();
    }

    public static List<AirportDTO> toDTO(List<Airport> airports) {
        return airports.stream()
                .map(AirportMapper::toDTO)
                .toList();
    }

    public static AirportDTOResponse toDTOResponse(Airport airport){
        return AirportDTOResponse.builder()
                .airportId(airport.getAirportId())
                .name(airport.getName())
                .city(CityMapper.toDTO(airport.getCity()))
                .build();
    }

    public static List<AirportDTOResponse> toDTOResponse(List<Airport> airports) {
        return airports.stream()
                .map(AirportMapper::toDTOResponse)
                .toList();
    }
}
