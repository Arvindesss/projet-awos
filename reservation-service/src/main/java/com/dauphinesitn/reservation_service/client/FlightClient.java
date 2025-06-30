package com.dauphinesitn.reservation_service.client;

import com.dauphinesitn.reservation_service.dto.FlightDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient(name = "flight-service")
public interface FlightClient {

    @GetMapping("/v1/flights/{flightId}")
    ResponseEntity<FlightDTO> getFlightById(@PathVariable UUID flightId);
}
