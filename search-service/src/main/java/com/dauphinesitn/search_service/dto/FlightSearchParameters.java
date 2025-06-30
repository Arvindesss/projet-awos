package com.dauphinesitn.search_service.dto;

import lombok.Builder;

import java.time.LocalDate;
import java.util.UUID;

@Builder
public record FlightSearchParameters(UUID departureAirportId,
                                     UUID arrivalAirportId,
                                     LocalDate departureDate,
                                     Double maxPrice) {
}
