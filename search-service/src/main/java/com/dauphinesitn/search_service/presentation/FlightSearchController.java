package com.dauphinesitn.search_service.presentation;

import com.dauphinesitn.search_service.dto.FlightSearchParameters;
import com.dauphinesitn.search_service.dto.FlightSearchResult;
import com.dauphinesitn.search_service.services.FlightSearchService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/flights-search")
@AllArgsConstructor
public class FlightSearchController {

    private FlightSearchService flightSearchService;

    @GetMapping("")
    public ResponseEntity<List<FlightSearchResult>> searchFlights(@RequestBody FlightSearchParameters flightSearchParameters) {
        List<FlightSearchResult> flightSearchResult = flightSearchService.searchFlights(flightSearchParameters);
        return ResponseEntity.ok(flightSearchResult);
    }
}
