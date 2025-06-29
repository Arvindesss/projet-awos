package com.dauphinesitn.inventory_service.dto;

import lombok.Builder;

import java.util.List;
import java.util.UUID;

@Builder
public record InventoryDTO(UUID flightId,
                           List<SeatInventoryDTO> seatInventory) {
}
