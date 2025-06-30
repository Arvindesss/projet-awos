package com.dauphinesitn.flight_service.client;

import com.dauphinesitn.flight_service.dto.AirportDTO;
import com.dauphinesitn.flight_service.dto.AirportDTOResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient(name = "location-service")
public interface AirportClient {

    @GetMapping("/v1/airports/{id}")
    ResponseEntity<AirportDTOResponse> getAirportById(@PathVariable UUID id);
}
