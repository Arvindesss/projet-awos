package com.dauphinesitn.flight_access_service.dto;

import lombok.Builder;

import java.util.List;
import java.util.UUID;

@Builder
public record InventoryDTO(UUID flightId,
                           List<SeatInventoryDTO> seatInventory,
                           List<ReservedLuggageDTO> luggages) {
}
