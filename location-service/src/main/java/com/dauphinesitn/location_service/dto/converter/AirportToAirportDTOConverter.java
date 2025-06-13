package com.dauphinesitn.location_service.dto.converter;

import com.dauphinesitn.location_service.dto.AirportDTO;
import com.dauphinesitn.location_service.model.Airport;

public class AirportToAirportDTOConverter {

    public static AirportDTO convert(Airport airport){
        return AirportDTO.builder()
                .airportId(airport.getAirportId())
                .name(airport.getName())
                .cityId(airport.getCity().getUuid())
                .countryId(airport.getCountry().getUuid())
                .build();
    }
}
