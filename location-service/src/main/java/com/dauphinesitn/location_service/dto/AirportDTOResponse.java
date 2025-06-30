package com.dauphinesitn.location_service.dto;

import lombok.Builder;

import java.util.UUID;

@Builder
public record AirportDTOResponse (UUID airportId,
                          String name,
                          CityDTOResponse city) {
}