package com.dauphinesitn.reservation_service.dto;

import jakarta.persistence.Entity;
import lombok.*;

import java.util.UUID;

@Builder
public record SeatInventoryDTO(
        UUID seatId,
        UUID flightId,
        boolean isAvailable) {
}
