package com.dauphinesitn.flight_access_service.client;

import com.dauphinesitn.flight_access_service.dto.InventoryAvailabilityDTO;
import com.dauphinesitn.flight_access_service.dto.InventoryDTO;
import com.dauphinesitn.flight_access_service.dto.SeatInventoryDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@FeignClient(name = "inventory-service")
public interface InventoryClient {

    @GetMapping("/v1/inventories/flight/{flightId}")
    ResponseEntity<InventoryDTO> getInventoryByFlightId(@PathVariable UUID flightId);

    @PutMapping("/v1/inventories/update-seat-availability")
    ResponseEntity<InventoryAvailabilityDTO> updateSeatAvailability(@RequestBody SeatInventoryDTO seatInventoryDTO);
}
