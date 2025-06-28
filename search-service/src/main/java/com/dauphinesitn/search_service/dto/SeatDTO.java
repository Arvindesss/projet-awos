package com.dauphinesitn.search_service.dto;

import lombok.Builder;

import java.util.UUID;

@Builder
public record SeatDTO(
        UUID planeId,
        String seatNumber,
        String description) {
}
