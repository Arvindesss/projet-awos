package com.dauphinesitn.reservation_service.dto;

import lombok.Builder;

import java.util.List;
import java.util.UUID;

@Builder
public record InventoryAvailabilityDTO(UUID flightId,
                                       int availableSeats,
                                       List<SeatInventoryDTO> seatInventory) {
}

