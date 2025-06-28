package com.dauphinesitn.search_service.dto;

import java.time.LocalDate;
import java.util.UUID;

public record FlightSearchParameters(UUID departureAirportId,
                                     UUID arrivalAirportId,
                                     LocalDate departureDate,
                                     Double maxPrice) {
}
