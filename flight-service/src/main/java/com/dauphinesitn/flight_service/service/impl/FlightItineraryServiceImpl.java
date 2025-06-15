package com.dauphinesitn.flight_service.service.impl;

import com.dauphinesitn.flight_service.dto.FlightItineraryDTO;
import com.dauphinesitn.flight_service.model.FlightItinerary;
import com.dauphinesitn.flight_service.model.FlightItineraryId;
import com.dauphinesitn.flight_service.repository.FlightItineraryRepository;
import com.dauphinesitn.flight_service.service.FlightItineraryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class FlightItineraryServiceImpl implements FlightItineraryService {

    private final FlightItineraryRepository flightItineraryRepository;

    @Override
    public List<FlightItinerary> getAllFlightItineraries() {
        return flightItineraryRepository.findAll();
    }

    @Override
    public FlightItinerary getFlightItineraryById(UUID departureAirportId, UUID arrivalAirportId) {
        FlightItineraryId flightItineraryId = new FlightItineraryId(departureAirportId, arrivalAirportId);
        return flightItineraryRepository.findById(flightItineraryId)
                .orElseThrow(() -> new IllegalArgumentException("Flight itinerary not found with ID: " + flightItineraryId));
    }

    @Override
    public FlightItinerary createFlightItinerary(FlightItineraryDTO flightItineraryDTO) {
        FlightItineraryId flightItineraryId = new FlightItineraryId(
                flightItineraryDTO.departureAirportId(),
                flightItineraryDTO.arrivalAirportId()
        );
        FlightItinerary flightItinerary = new FlightItinerary();
        flightItinerary.setFlightItineraryId(flightItineraryId);
        return flightItineraryRepository.save(flightItinerary);
    }

    @Override
    public FlightItinerary deleteFlightItinerary(UUID flightItineraryId) {
        FlightItineraryId id = new FlightItineraryId(flightItineraryId, flightItineraryId);
        FlightItinerary flightItinerary = flightItineraryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Flight itinerary not found with ID: " + id));
        flightItineraryRepository.delete(flightItinerary);
        return flightItinerary;
    }
}
