package com.dauphinesitn.location_service.mapper;

import com.dauphinesitn.location_service.dto.AirportDTO;
import com.dauphinesitn.location_service.model.Airport;

public class AirportMapper {

    public static AirportDTO toDTO(Airport airport){
        return AirportDTO.builder()
                .airportId(airport.getAirportId())
                .name(airport.getName())
                .cityId(airport.getCity().getUuid())
                .countryId(airport.getCountry().getUuid())
                .build();
    }
}
