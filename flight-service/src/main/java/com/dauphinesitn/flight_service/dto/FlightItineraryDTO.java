package com.dauphinesitn.flight_service.dto;

import lombok.*;

import java.util.UUID;

@Builder
public record FlightItineraryDTO(UUID departureAirportId,
                                 UUID arrivalAirportId) {
}
