package com.dauphinesitn.search_service.dto;

import lombok.Builder;

import java.util.UUID;

@Builder
public record AirportDTOResponse(UUID airportId,
                                 String name,
                                 CityDTOResponse city) {
}