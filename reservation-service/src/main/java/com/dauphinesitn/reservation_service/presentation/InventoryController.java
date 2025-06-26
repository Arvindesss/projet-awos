package com.dauphinesitn.reservation_service.presentation;

import com.dauphinesitn.reservation_service.dto.InventoryDTO;
import com.dauphinesitn.reservation_service.dto.ReservedLuggageDTO;
import com.dauphinesitn.reservation_service.dto.SeatInventoryDTO;
import com.dauphinesitn.reservation_service.mapper.InventoryMapper;
import com.dauphinesitn.reservation_service.model.Inventory;
import com.dauphinesitn.reservation_service.service.InventoryService;
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

    @GetMapping("/")
    public ResponseEntity<List<InventoryDTO>> getAllInventory() {
        List<Inventory> inventoryList = inventoryService.getAllInventory();
        return ResponseEntity.ok(InventoryMapper.toDto(inventoryList));
    }

    @GetMapping("/flight/{flightId}")
    public ResponseEntity<InventoryDTO> getInventoryByFlightId(@PathVariable UUID flightId) {
        Inventory inventory = inventoryService.getInventoryByFlightId(flightId);
        return ResponseEntity.ok(InventoryMapper.toDto(inventory));
    }

    @PatchMapping("/update-seat-availability")
    public ResponseEntity<InventoryDTO> updateSeatAvailability(@PathVariable UUID flightId, @RequestBody SeatInventoryDTO seatInventoryDTO) {
        Inventory updatedInventory = inventoryService.updateSeatAvailability(flightId, seatInventoryDTO);
        return ResponseEntity.ok(InventoryMapper.toDto(updatedInventory));
    }

    @PatchMapping("/add-luggages/{flightId}")
    public ResponseEntity<InventoryDTO> addLuggage(@PathVariable UUID flightId, @RequestBody List<ReservedLuggageDTO> reservedLuggageDTOS) {
        Inventory updatedInventory = inventoryService.addLuggages(flightId, reservedLuggageDTOS);
        return ResponseEntity.ok(InventoryMapper.toDto(updatedInventory));
    }

    @PostMapping("/create")
    public ResponseEntity<InventoryDTO> createInventory(@RequestBody InventoryDTO inventoryDTO) {
        Inventory createdInventory = inventoryService.createInventory(inventoryDTO);
        return ResponseEntity.ok(InventoryMapper.toDto(createdInventory));
    }

    @DeleteMapping("/delete/{flightId}")
    public ResponseEntity<InventoryDTO> deleteInventory(@PathVariable UUID flightId) {
        Inventory deletedInventory = inventoryService.deleteInventory(flightId);
        return ResponseEntity.ok(InventoryMapper.toDto(deletedInventory));
    }
}
