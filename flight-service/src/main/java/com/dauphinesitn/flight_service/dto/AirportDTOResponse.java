package com.dauphinesitn.flight_service.dto;


import lombok.Builder;

import java.util.UUID;

@Builder
public record AirportDTOResponse(UUID airportId,
                                 String name,
                                 CityDTO city) {
}