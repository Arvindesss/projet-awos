package com.dauphinesitn.search_service.client;

import com.dauphinesitn.search_service.dto.FlightDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "flight-service")
public interface FlightClient {

    @GetMapping("/v1/flights")
    ResponseEntity<List<FlightDTO>> getAllFlights();

}
