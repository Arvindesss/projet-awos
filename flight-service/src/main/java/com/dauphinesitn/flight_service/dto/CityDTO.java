package com.dauphinesitn.flight_service.dto;

import lombok.Builder;

import java.util.UUID;

@Builder
public record CityDTO(UUID uuid,
                      String name,
                      String postalCode,
                      CountryDTO country) {
}
