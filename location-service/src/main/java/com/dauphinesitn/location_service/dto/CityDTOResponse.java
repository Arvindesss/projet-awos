package com.dauphinesitn.location_service.dto;

import lombok.Builder;

import java.util.UUID;

@Builder
public record CityDTOResponse(UUID uuid,
                              String name,
                              String postalCode,
                              CountryDTO country) {
}
