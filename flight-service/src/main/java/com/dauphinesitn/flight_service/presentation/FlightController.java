package com.dauphinesitn.flight_service.presentation;

import com.dauphinesitn.flight_service.dto.FlightDTO;
import com.dauphinesitn.flight_service.dto.converter.FlightToFlightDTOConverter;
import com.dauphinesitn.flight_service.model.Flight;
import com.dauphinesitn.flight_service.service.FlightService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/flights")
@AllArgsConstructor
public class FlightController {

    private final FlightService flightService;


    @GetMapping("/")
    public ResponseEntity<List<FlightDTO>> getAllFlights() {
        List<Flight> flights = flightService.getAllFlights();
        return ResponseEntity.ok(FlightToFlightDTOConverter.convert(flights));
    }

    @GetMapping("/{flightId}")
    public ResponseEntity<FlightDTO> getFlightById(@PathVariable UUID flightId) {
        Flight flight = flightService.getFlightById(flightId);
        return ResponseEntity.ok(FlightToFlightDTOConverter.convert(flight));
    }

    @PostMapping("/create")
    public ResponseEntity<FlightDTO> createFlight(@RequestBody FlightDTO flightDTO) {
        Flight flight = flightService.createFlight(flightDTO);
        return ResponseEntity.ok(FlightToFlightDTOConverter.convert(flight));
    }

    @PutMapping("/update/{flightId}")
    public ResponseEntity<FlightDTO> updateFlight(UUID flightId, @RequestBody FlightDTO flightDTO) {
        Flight flight = flightService.updateFlight(flightId, flightDTO);
        return ResponseEntity.ok(FlightToFlightDTOConverter.convert(flight));
    }

    @DeleteMapping("/delete/{flightId}")
    public ResponseEntity<FlightDTO> deleteFlight(UUID flightId) {
        Flight flight = flightService.deleteFlight(flightId);
        return ResponseEntity.ok(FlightToFlightDTOConverter.convert(flight));
    }
}
