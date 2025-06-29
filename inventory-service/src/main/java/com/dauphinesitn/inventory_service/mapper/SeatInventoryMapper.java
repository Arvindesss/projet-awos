package com.dauphinesitn.inventory_service.mapper;

import com.dauphinesitn.inventory_service.dto.SeatDTO;
import com.dauphinesitn.inventory_service.dto.SeatInventoryDTO;
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

    public static SeatInventory toEntity(SeatInventoryDTO seatInventoryDTO) {
        return SeatInventory.builder()
                .seatInventoryId(new SeatInventoryId(seatInventoryDTO.flightId(), seatInventoryDTO.seatNumber()))
                .isAvailable(seatInventoryDTO.isAvailable())
                .build();
    }

    public static List<SeatInventory> toEntity(List<SeatInventoryDTO> seatInventoryDTOs) {
        return seatInventoryDTOs.stream()
                .map(SeatInventoryMapper::toEntity)
                .toList();
    }

    public static List<SeatInventory> convertPlaneSeats(List<SeatDTO> seatDTOs, UUID flightId) {
        return seatDTOs.stream()
                .map(seatDTO -> SeatInventory.builder()
                        .seatInventoryId(new SeatInventoryId(flightId,seatDTO.seatNumber()))
                        .isAvailable(true) // Assuming all seats are available initially
                        .build())
                .toList();
    }
}
