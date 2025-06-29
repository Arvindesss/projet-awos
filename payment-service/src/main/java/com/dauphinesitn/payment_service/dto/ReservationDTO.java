package com.dauphinesitn.payment_service.dto;

import lombok.Builder;

import java.util.UUID;

@Builder
public record ReservationDTO(UUID reservationId,
                             UUID customerId,
                             UUID flightId,
                             double price,
                             String currency,
                             String seatNumber,
                             ReservationDTO.Status status) {
    public enum Status {
        PENDING,
        CONFIRMED,
        CANCELLED
    }
}
