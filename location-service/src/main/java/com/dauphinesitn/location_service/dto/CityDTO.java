package com.dauphinesitn.location_service.dto;

import com.dauphinesitn.location_service.model.Country;
import lombok.Builder;

import java.util.UUID;

@Builder
public record CityDTO(UUID uuid,
                      String name,
                      String postalCode,
                      Country country) {
}
