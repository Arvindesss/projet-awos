package com.dauphinesitn.reservation_service.mapper;

import com.dauphinesitn.reservation_service.dto.SeatInventoryDTO;
import com.dauphinesitn.reservation_service.model.SeatInventory;
import com.dauphinesitn.reservation_service.model.SeatInventoryId;

import java.util.List;

public class SeatInventoryMapper {

    public static SeatInventoryDTO toDto(SeatInventory seatInventory) {
        return SeatInventoryDTO.builder()
                .seatId(seatInventory.getSeatInventoryId().getSeatId())
                .flightId(seatInventory.getSeatInventoryId().getFlightId())
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
                .seatInventoryId(new SeatInventoryId(seatInventoryDTO.seatId(), seatInventoryDTO.flightId()))
                .isAvailable(seatInventoryDTO.isAvailable())
                .build();
    }

    public static List<SeatInventory> toEntity(List<SeatInventoryDTO> seatInventoryDTOs) {
        return seatInventoryDTOs.stream()
                .map(SeatInventoryMapper::toEntity)
                .toList();
    }
}
