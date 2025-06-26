package com.dauphinesitn.reservation_service.dto;

import lombok.Builder;

import java.util.List;
import java.util.UUID;

@Builder
public record ReservationDTO(UUID reservationId,
                             UUID customerId,
                             UUID flightId,
                             PriceDTO price,
                             SeatInventoryDTO seatAvailability,
                             List<ReservedLuggageDTO> luggages) {
}
