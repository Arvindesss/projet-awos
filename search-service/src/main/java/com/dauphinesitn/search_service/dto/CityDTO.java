package com.dauphinesitn.search_service.dto;

import lombok.Builder;

import java.util.UUID;

@Builder
public record CityDTO(UUID uuid,
                      String name,
                      String postalCode,
                      CountryDTO country) {
}
