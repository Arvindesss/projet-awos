package com.dauphinesitn.search_service.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.util.UUID;

public class FlightSearchResult {

    private UUID flightId;

    private PlaneDTO plane;

    private AirportDTO departureAirport;

    private AirportDTO arrivalAirport;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime departureTime;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime arrivalTime;
}
