package com.dauphinesitn.flight_service.presentation;

import com.dauphinesitn.flight_service.dto.FlightItineraryCompleteDTO;
import com.dauphinesitn.flight_service.dto.FlightItineraryDTO;
import com.dauphinesitn.flight_service.dto.converter.FlightItineraryToFlightItineraryDTOConverter;
import com.dauphinesitn.flight_service.model.FlightItinerary;
import com.dauphinesitn.flight_service.service.FlightItineraryService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/itineraries")
@AllArgsConstructor
public class FlightItineraryController {

    private final FlightItineraryService flightItineraryService;

    @GetMapping("")
    public ResponseEntity<List<FlightItineraryDTO>> getAllFlightItineraries() {
        List<FlightItinerary> flightItineraries = flightItineraryService.getAllFlightItineraries();
        return ResponseEntity.ok(FlightItineraryToFlightItineraryDTOConverter.convert(flightItineraries));
    }

    @GetMapping("/get-by-id")
    public ResponseEntity<FlightItineraryCompleteDTO> getFlightItineraryById(@RequestBody FlightItineraryDTO flightItineraryDTO) {
        FlightItineraryCompleteDTO flightItinerary = flightItineraryService.getFlightItineraryById(flightItineraryDTO);
        return ResponseEntity.ok(flightItinerary);
    }

    @PostMapping("/create")
    public ResponseEntity<FlightItineraryDTO> createFlightItinerary(@RequestBody FlightItineraryDTO flightItineraryDTO) {
        FlightItinerary flightItinerary = flightItineraryService.createFlightItinerary(flightItineraryDTO);
        return ResponseEntity.created(URI.create("/v1/itineraries/" + flightItinerary.getFlightItineraryId()))
                .body((FlightItineraryToFlightItineraryDTOConverter.convert(flightItinerary)));
    }

    @DeleteMapping("/delete/{flightItineraryId}")
    public ResponseEntity<FlightItineraryDTO> deleteFlightItinerary(@PathVariable UUID flightItineraryId) {
        FlightItinerary flightItinerary = flightItineraryService.deleteFlightItinerary(flightItineraryId);
        return ResponseEntity.ok(FlightItineraryToFlightItineraryDTOConverter.convert(flightItinerary));
    }
}
