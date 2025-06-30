package com.dauphinesitn.pricing_service.dto;

import lombok.Builder;

import java.util.UUID;

@Builder
public record CityDTO(UUID uuid,
                      String name,
                      String postalCode,
                      UUID countryId) {
}
