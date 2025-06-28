package com.dauphinesitn.flight_access_service.dto;

import lombok.Builder;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
public record BoardingDTO (UUID boardingId,
                           UUID cardId,
                           UUID customerId,
                           UUID reservationId,
                           CheckInDTO checkIn,
                           LocalDateTime boardingTime) {
}
