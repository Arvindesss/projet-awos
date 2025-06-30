package com.dauphinesitn.location_service.presentation;

import com.dauphinesitn.location_service.dto.AirportDTO;
import com.dauphinesitn.location_service.dto.AirportDTOResponse;
import com.dauphinesitn.location_service.mapper.AirportMapper;
import com.dauphinesitn.location_service.model.Airport;
import com.dauphinesitn.location_service.service.AirportService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/airports")
@AllArgsConstructor
public class AirportController {

    private final AirportService airportService;

    @GetMapping("")
    public ResponseEntity<List<AirportDTOResponse>> getAllAirports() {
        List<Airport> airport = airportService.getAllAirports();
        return ResponseEntity.ok(AirportMapper.toDTOResponse(airport));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AirportDTOResponse> getAirportById(@PathVariable UUID id) {
        Airport airport = airportService.getAirportById(id);
        return ResponseEntity.ok(AirportMapper.toDTOResponse(airport));
    }

    @GetMapping("/name")
    public ResponseEntity<AirportDTOResponse> getAirportByName(@RequestParam String airportName) {
        Airport airport = airportService.getAirportByName(airportName);
        return ResponseEntity.ok(AirportMapper.toDTOResponse(airport));
    }

    @PostMapping("/create")
    public ResponseEntity<AirportDTOResponse> createAirport(@RequestBody AirportDTO airportDTO) {
        Airport airport = airportService.createAirport(airportDTO);
        return ResponseEntity.created(URI.create("/v1/airports/" + airport.getAirportId()))
                .body(AirportMapper.toDTOResponse(airport));
    }

    @PutMapping("/update")
    public ResponseEntity<AirportDTOResponse> updateAirport(@PathVariable UUID id, AirportDTO airportDTO) {
        Airport airport = airportService.updateAirport(id, airportDTO);
        return ResponseEntity.created(URI.create("/v1/airports/" + airport.getAirportId()))
                .body(AirportMapper.toDTOResponse(airport));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<AirportDTOResponse> deleteAirport(@PathVariable UUID id) {
        Airport airport = airportService.deleteAirport(id);
        return ResponseEntity.ok(AirportMapper.toDTOResponse(airport));
    }
}
