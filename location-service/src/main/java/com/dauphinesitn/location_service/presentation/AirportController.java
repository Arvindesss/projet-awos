package com.dauphinesitn.location_service.presentation;

import com.dauphinesitn.location_service.dto.AirportDTO;
import com.dauphinesitn.location_service.mapper.AirportMapper;
import com.dauphinesitn.location_service.model.Airport;
import com.dauphinesitn.location_service.service.AirportService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("/v1/airports")
@AllArgsConstructor
public class AirportController {

    private final AirportService airportService;

    @RequestMapping("/{id}")
    public ResponseEntity<AirportDTO> getAirportById(@PathVariable UUID id) {
        Airport airport = airportService.getAirportById(id);
        return ResponseEntity.ok(AirportMapper.toDTO(airport));
    }
    @RequestMapping("/{name}")
    public ResponseEntity<AirportDTO> getAirportByName(@PathVariable String name) {
        Airport airport = airportService.getAirportByName(name);
        return ResponseEntity.ok(AirportMapper.toDTO(airport));
    }

    @RequestMapping("/create")
    public ResponseEntity<AirportDTO> createAirport(AirportDTO airportDTO) {
        Airport airport = airportService.createAirport(airportDTO);
        return ResponseEntity.created(URI.create("/v1/airports/" + airport.getAirportId()))
                .body(AirportMapper.toDTO(airport));
    }

    @RequestMapping("/update")
    public ResponseEntity<AirportDTO> updateAirport(@PathVariable UUID id, AirportDTO airportDTO) {
        Airport airport = airportService.updateAirport(id, airportDTO);
        return ResponseEntity.created(URI.create("/v1/airports/" + airport.getAirportId()))
                .body(AirportMapper.toDTO(airport));
    }

    @RequestMapping("/delete/{id}")
    public ResponseEntity<AirportDTO> deleteAirport(@PathVariable UUID id) {
        Airport airport = airportService.deleteAirport(id);
        return ResponseEntity.ok(AirportMapper.toDTO(airport));
    }
}
