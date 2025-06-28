package com.dauphinesitn.search_service.dto;

import lombok.Builder;

import java.util.UUID;

@Builder
public record AirportDTO(UUID airportId,
                         String name,
                         UUID cityId,
                         UUID countryId) {
}
