package com.dauphinesitn.flight_service.dto;

import lombok.Builder;

@Builder
public record FlightItineraryCompleteDTO(AirportDTOResponse departureAirport,
                                         AirportDTOResponse arrivalAirport) {
}