package com.dauphinesitn.flight_access_service.client;

import com.dauphinesitn.flight_access_service.dto.InventoryDTO;
import com.dauphinesitn.flight_access_service.dto.SeatInventoryDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;

@FeignClient(name = "inventory-service")
public interface InventoryClient {

    @GetMapping("/v1/inventories/flight/{flightId}")
    ResponseEntity<InventoryDTO> getInventoryByFlightId(@PathVariable UUID flightId);

    @PatchMapping("/v1/inventories/update-seat-availability")
    ResponseEntity<InventoryDTO> updateSeatAvailability(@RequestBody SeatInventoryDTO seatInventoryDTO);
}
