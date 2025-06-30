package com.dauphinesitn.inventory_service.mapper;

import com.dauphinesitn.inventory_service.dto.InventoryAvailabilityDTO;
import com.dauphinesitn.inventory_service.dto.InventoryDTO;
import com.dauphinesitn.inventory_service.model.Inventory;
import com.dauphinesitn.inventory_service.model.SeatInventory;

import java.util.List;

public class InventoryMapper {

    public static InventoryDTO toDto(Inventory inventory) {
        return InventoryDTO.builder()
                .flightId(inventory.getFlightId())
                .seatInventory(SeatInventoryMapper.toDto(inventory.getSeatInventory()))
                .build();
    }

    public static List<InventoryDTO> toDto(List<Inventory> inventories) {
        return inventories.stream()
                .map(InventoryMapper::toDto)
                .toList();
    }

    public static InventoryAvailabilityDTO toAvailabilityDto(Inventory inventory) {
        return InventoryAvailabilityDTO.builder()
                .flightId(inventory.getFlightId())
                .seatInventory(SeatInventoryMapper.toDto(inventory.getSeatInventory()))
                .availableSeats(
                        inventory.getSeatInventory() == null ? 0 :
                                (int) inventory.getSeatInventory().stream()
                                        .filter(SeatInventory::isAvailable) // méthode de référence + null check possible
                                        .count()
                )
                .build();
    }

    public static List<InventoryAvailabilityDTO> toAvailabilityDto(List<Inventory> inventories) {
        return inventories.stream()
                .map(InventoryMapper::toAvailabilityDto)
                .toList();
    }
}
