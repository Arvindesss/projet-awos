package com.dauphinesitn.search_service.presentation;

import com.dauphinesitn.search_service.dto.FlightSearchParameters;
import com.dauphinesitn.search_service.dto.FlightSearchResult;
import com.dauphinesitn.search_service.services.FlightSearchService;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/flights-search")
@AllArgsConstructor
public class FlightSearchController {

    private FlightSearchService flightSearchService;

    @GetMapping("")
    public ResponseEntity<List<FlightSearchResult>> searchFlights(@RequestParam UUID departureAirportId,
                                                                  @RequestParam UUID arrivalAirportId,
                                                                  @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate departureDate,
                                                                  @RequestParam(required = false) Double maxPrice) {
        FlightSearchParameters flightSearchParameters = FlightSearchParameters.builder()
                .departureAirportId(departureAirportId)
                .arrivalAirportId(arrivalAirportId)
                .departureDate(departureDate)
                .maxPrice(maxPrice)
                .build();
        List<FlightSearchResult> flightSearchResult = flightSearchService.searchFlights(flightSearchParameters);
        return ResponseEntity.ok(flightSearchResult);
    }
}
