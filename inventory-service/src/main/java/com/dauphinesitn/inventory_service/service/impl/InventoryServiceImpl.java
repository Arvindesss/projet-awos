package com.dauphinesitn.inventory_service.service.impl;

import com.dauphinesitn.inventory_service.client.FlightClient;
import com.dauphinesitn.inventory_service.dto.FlightDTO;
import com.dauphinesitn.inventory_service.dto.InventoryDTO;
import com.dauphinesitn.inventory_service.dto.SeatDTO;
import com.dauphinesitn.inventory_service.dto.SeatInventoryDTO;
import com.dauphinesitn.inventory_service.mapper.SeatInventoryMapper;
import com.dauphinesitn.inventory_service.model.Inventory;
import com.dauphinesitn.inventory_service.model.SeatInventory;
import com.dauphinesitn.inventory_service.repository.InventoryRepository;
import com.dauphinesitn.inventory_service.service.InventoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class InventoryServiceImpl implements InventoryService {

    private final InventoryRepository inventoryRepository;

    private final FlightClient flightClient;

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
                filter(seat -> seat.getSeatInventoryId().getSeatNumber().equals(seatInventoryDTO.seatNumber()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Seat not found in inventory: " + seatInventoryDTO.seatNumber()));
        seatInventory.setAvailable(!seatInventory.isAvailable());
        return inventoryRepository.save(existingInventory);
    }

    @Override
    public Inventory createInventory(InventoryDTO inventory) {
        FlightDTO flightDTO = flightClient.getFlightById(inventory.flightId()).getBody();
        List<SeatDTO> seatDTOs = flightDTO.plane().seats();
        List<SeatInventory> seatInventories = SeatInventoryMapper.convertPlaneSeats(seatDTOs, inventory.flightId());
        Inventory newInventory = Inventory.builder()
                .flightId(inventory.flightId())
                .seatInventory(seatInventories)
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
