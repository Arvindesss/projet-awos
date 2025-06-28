package com.dauphinesitn.reservation_service.service.impl;

import com.dauphinesitn.reservation_service.dto.InventoryDTO;
import com.dauphinesitn.reservation_service.dto.ReservedLuggageDTO;
import com.dauphinesitn.reservation_service.dto.SeatInventoryDTO;
import com.dauphinesitn.reservation_service.mapper.LuggageMapper;
import com.dauphinesitn.reservation_service.mapper.SeatInventoryMapper;
import com.dauphinesitn.reservation_service.model.Inventory;
import com.dauphinesitn.reservation_service.model.SeatInventory;
import com.dauphinesitn.reservation_service.repository.InventoryRepository;
import com.dauphinesitn.reservation_service.service.InventoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class InventoryServiceImpl implements InventoryService {

    private final InventoryRepository inventoryRepository;


    @Override
    public List<Inventory> getAllInventory() {
        return inventoryRepository.findAll();
    }

    @Override
    public Inventory getInventoryByFlightId(UUID flightId) {
        return inventoryRepository.findById(flightId).orElse(null);
    }

    @Override
    public Inventory updateSeatAvailability(UUID flightId, SeatInventoryDTO seatInventoryDTO) {
        Inventory existingInventory = inventoryRepository.findById(flightId)
                .orElseThrow(() -> new IllegalArgumentException("Inventory not found for flight ID: " + flightId));
        SeatInventory seatInventory = existingInventory.getSeatInventory().stream().
                filter(seat -> seat.getSeatInventoryId().getSeatId().equals(seatInventoryDTO.seatId()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Seat not found in inventory: " + seatInventoryDTO.seatId()));
        seatInventory.setAvailable(seatInventoryDTO.isAvailable());
        return inventoryRepository.save(existingInventory);
    }

    @Override
    public Inventory addLuggages(UUID flightId, List<ReservedLuggageDTO> luggages) {
        Inventory existingInventory = inventoryRepository.findById(flightId)
                .orElseThrow(() -> new IllegalArgumentException("Inventory not found for flight ID: " + flightId));
        existingInventory.getReservedLuggages().addAll(LuggageMapper.toEntity(luggages));
        return inventoryRepository.save(existingInventory);
    }

    @Override
    public Inventory createInventory(InventoryDTO inventory) {
        Inventory newInventory = Inventory.builder()
                .flightId(UUID.randomUUID())
                .seatInventory(SeatInventoryMapper.toEntity(inventory.seatInventory()))
                .reservedLuggages(LuggageMapper.toEntity(inventory.luggages()))
                .build();
        return inventoryRepository.save(newInventory);
    }

    @Override
    public Inventory deleteInventory(UUID flightId) {
        Inventory inventory = inventoryRepository.findById(flightId)
                .orElseThrow(() -> new IllegalArgumentException("Inventory not found for flight ID: " + flightId));
        inventoryRepository.delete(inventory);
        return inventory;
    }
}
