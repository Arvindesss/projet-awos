package com.dauphinesitn.reservation_service.dto;

import com.dauphinesitn.reservation_service.model.SeatInventory;
import lombok.Builder;

import java.util.List;
import java.util.UUID;

@Builder
public record InventoryDTO(UUID flightId,
                           List<SeatInventoryDTO> seatInventory,
                           List<LuggageDTO> luggages) {
}
