package com.dauphinesitn.search_service.client;


import com.dauphinesitn.search_service.dto.InventoryAvailabilityDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient(name = "inventory-service")
public interface InventoryClient {

    @GetMapping("/v1/inventories/flight/{flightId}")
    ResponseEntity<InventoryAvailabilityDTO> getInventoryByFlightId(@PathVariable UUID flightId);
}
