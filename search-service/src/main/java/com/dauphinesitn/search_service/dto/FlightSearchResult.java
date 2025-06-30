package com.dauphinesitn.search_service.dto;

import lombok.Builder;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
public record FlightSearchResult(UUID flightId,
                                PlaneDTO plane,
                                AirportDTOResponse departureAirport,
                                AirportDTOResponse arrivalAirport,
                                double price,
                                LocalDateTime departureTime,
                                LocalDateTime arrivalTime) {

}
