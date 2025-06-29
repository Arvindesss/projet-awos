package com.dauphinesitn.inventory_service.dto;

import lombok.Builder;

import java.util.UUID;

@Builder
public record SeatInventoryDTO(
        UUID flightId,
        String seatNumber,
        boolean isAvailable) {
}
