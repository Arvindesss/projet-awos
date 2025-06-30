package com.dauphinesitn.search_service.client;

import com.dauphinesitn.search_service.dto.AirportDTOResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient(name = "location-service")
public interface LocationClient {

    @GetMapping("/v1/airports/{id}")
    ResponseEntity<AirportDTOResponse> getAirportById(@PathVariable("id") UUID id);

}
