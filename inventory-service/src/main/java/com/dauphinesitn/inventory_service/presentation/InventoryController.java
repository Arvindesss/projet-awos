package com.dauphinesitn.inventory_service.presentation;


import com.dauphinesitn.inventory_service.dto.InventoryAvailabilityDTO;
import com.dauphinesitn.inventory_service.dto.InventoryDTO;
import com.dauphinesitn.inventory_service.dto.SeatInventoryDTO;
import com.dauphinesitn.inventory_service.mapper.InventoryMapper;
import com.dauphinesitn.inventory_service.model.Inventory;
import com.dauphinesitn.inventory_service.service.InventoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/inventories")
@AllArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    @GetMapping("")
    public ResponseEntity<List<InventoryAvailabilityDTO>> getAllInventory() {
        List<Inventory> inventoryList = inventoryService.getAllInventory();
        return ResponseEntity.ok(InventoryMapper.toAvailabilityDto(inventoryList));
    }

    @GetMapping("/flight/{flightId}")
    public ResponseEntity<InventoryAvailabilityDTO> getInventoryByFlightId(@PathVariable UUID flightId) {
        Inventory inventory = inventoryService.getInventoryByFlightId(flightId);
        return ResponseEntity.ok(InventoryMapper.toAvailabilityDto(inventory));
    }

    @PutMapping("/update-seat-availability")
    public ResponseEntity<InventoryAvailabilityDTO> updateSeatAvailability(@RequestBody SeatInventoryDTO seatInventoryDTO) {
        Inventory updatedInventory = inventoryService.updateSeatAvailability(seatInventoryDTO);
        return ResponseEntity.ok(InventoryMapper.toAvailabilityDto(updatedInventory));
    }

    @PostMapping("/create/{flightId}")
    public ResponseEntity<InventoryAvailabilityDTO> createInventory(@PathVariable UUID flightId) {
        Inventory createdInventory = inventoryService.createInventory(flightId);
        return ResponseEntity.ok(InventoryMapper.toAvailabilityDto(createdInventory));
    }

    @DeleteMapping("/delete/{flightId}")
    public ResponseEntity<InventoryAvailabilityDTO> deleteInventory(@PathVariable UUID flightId) {
        Inventory deletedInventory = inventoryService.deleteInventory(flightId);
        return ResponseEntity.ok(InventoryMapper.toAvailabilityDto(deletedInventory));
    }
}
