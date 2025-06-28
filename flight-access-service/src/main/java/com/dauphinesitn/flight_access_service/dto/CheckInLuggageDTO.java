package com.dauphinesitn.flight_access_service.dto;

import lombok.Builder;

import java.util.UUID;

@Builder
public record CheckInLuggageDTO(
        UUID luggageId,
        double height,
        double weight) {
}
