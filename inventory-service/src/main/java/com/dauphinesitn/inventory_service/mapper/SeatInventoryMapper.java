package com.dauphinesitn.inventory_service.mapper;

import com.dauphinesitn.inventory_service.dto.SeatDTO;
import com.dauphinesitn.inventory_service.dto.SeatInventoryDTO;
import com.dauphinesitn.inventory_service.model.Inventory;
import com.dauphinesitn.inventory_service.model.SeatInventory;
import com.dauphinesitn.inventory_service.model.SeatInventoryId;

import java.util.List;
import java.util.UUID;

public class SeatInventoryMapper {

    public static SeatInventoryDTO toDto(SeatInventory seatInventory) {
        return SeatInventoryDTO.builder()
                .flightId(seatInventory.getSeatInventoryId().getFlightId())
                .seatNumber(seatInventory.getSeatInventoryId().getSeatNumber())
                .isAvailable(seatInventory.isAvailable())
                .build();
    }

    public static List<SeatInventoryDTO> toDto(List<SeatInventory> seatInventory) {
        return seatInventory.stream()
                .map(SeatInventoryMapper::toDto)
                .toList();
    }

    public static List<SeatInventory> convertPlaneSeats(List<SeatDTO> seatDTOs, UUID flightId, Inventory inventory) {
        return seatDTOs.stream()
                .map(seatDTO -> SeatInventory.builder()
                        .seatInventoryId(new SeatInventoryId(flightId,seatDTO.seatNumber()))
                        .isAvailable(true)
                        .inventory(inventory)
                        .build())
                .toList();
    }
}
