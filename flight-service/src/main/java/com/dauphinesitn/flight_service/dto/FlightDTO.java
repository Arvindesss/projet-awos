package com.dauphinesitn.flight_service.dto;

import lombok.Builder;

import java.time.LocalDateTime;
import java.util.UUID;


@Builder
public record FlightDTO (UUID flightId,
                        PlaneDTO plane,
                        FlightItineraryDTO flightItineraryDTO,
                        LocalDateTime departureTime,
                        LocalDateTime arrivalTime) {
}
