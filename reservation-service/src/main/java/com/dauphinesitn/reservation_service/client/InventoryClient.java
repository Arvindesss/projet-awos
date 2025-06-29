package com.dauphinesitn.reservation_service.client;

import com.dauphinesitn.reservation_service.dto.InventoryAvailabilityDTO;
import com.dauphinesitn.reservation_service.dto.SeatInventoryDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient(name = "inventory-service")
public interface InventoryClient {

    @GetMapping("/v1/inventories/flight/{flightId}")
    ResponseEntity<InventoryAvailabilityDTO> getInventoryByFlightId(@PathVariable UUID flightId);

    @PatchMapping("/v1/inventories/update-seat-availability/{flightId}")
    ResponseEntity<InventoryAvailabilityDTO> updateSeatAvailability(@PathVariable UUID flightId, SeatInventoryDTO seatInventoryDTO);

}
