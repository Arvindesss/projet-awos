package com.dauphinesitn.search_service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.dauphinesitn.search_service.dto.AirportDTO;

import java.util.UUID;

@FeignClient(name = "location-service")
public interface LocationClient {

    @GetMapping("/api/airports/{id}")
    ResponseEntity<AirportDTO> getAirportById(@PathVariable("id") UUID id);

}
