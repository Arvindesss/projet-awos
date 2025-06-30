package com.dauphinesitn.flight_service.dto;

import lombok.Builder;

import java.util.UUID;

@Builder
public record CountryDTO(UUID uuid,
                         String name,
                         String currency) {
}
