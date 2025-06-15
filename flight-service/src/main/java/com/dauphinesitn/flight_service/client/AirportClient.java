package com.dauphinesitn.flight_service.client;

import com.dauphinesitn.flight_service.dto.AirportDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient(name = "location-service")
public interface AirportClient {

    @GetMapping("/v1/airports/{id}")
    AirportDTO getAirportById(@PathVariable UUID id);
}
