package com.dauphinesitn.search_service.dto;

import lombok.Builder;

import java.util.UUID;

@Builder
public record CountryDTO(UUID uuid,
                         String name,
                         String currency) {
}
