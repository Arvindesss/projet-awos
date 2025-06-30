package com.dauphinesitn.reservation_service.dto;

import lombok.*;

import java.util.UUID;

@Builder
public record SeatInventoryDTO(
        UUID flightId,
        String seatNumber,
        boolean isAvailable) {
}
