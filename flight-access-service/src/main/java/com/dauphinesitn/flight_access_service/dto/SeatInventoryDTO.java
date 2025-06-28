package com.dauphinesitn.flight_access_service.dto;

import lombok.Builder;

import java.util.UUID;

@Builder
public record SeatInventoryDTO(
        UUID seatId,
        UUID flightId,
        boolean isAvailable) {
}
