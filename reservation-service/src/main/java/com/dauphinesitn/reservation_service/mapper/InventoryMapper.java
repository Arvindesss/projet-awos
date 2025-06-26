package com.dauphinesitn.reservation_service.mapper;

import com.dauphinesitn.reservation_service.dto.InventoryDTO;
import com.dauphinesitn.reservation_service.model.Inventory;

import java.util.List;

public class InventoryMapper {

    public static InventoryDTO toDto(Inventory inventory) {
        return InventoryDTO.builder()
                .flightId(inventory.getFlightId())
                .seatInventory(SeatInventoryMapper.toDto(inventory.getSeatInventory()))
                .luggages(LuggageMapper.toDto(inventory.getReservedLuggages()))
                .build();
    }

    public static List<InventoryDTO> toDto(List<Inventory> inventories) {
        return inventories.stream()
                .map(InventoryMapper::toDto)
                .toList();
    }
}
