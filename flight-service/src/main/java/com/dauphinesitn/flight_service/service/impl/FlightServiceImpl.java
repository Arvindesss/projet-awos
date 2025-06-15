package com.dauphinesitn.flight_service.service.impl;

import com.dauphinesitn.flight_service.dto.FlightDTO;
import com.dauphinesitn.flight_service.model.Flight;
import com.dauphinesitn.flight_service.model.FlightItinerary;
import com.dauphinesitn.flight_service.model.FlightItineraryId;
import com.dauphinesitn.flight_service.model.Plane;
import com.dauphinesitn.flight_service.repository.FlightItineraryRepository;
import com.dauphinesitn.flight_service.repository.FlightRepository;
import com.dauphinesitn.flight_service.repository.PlaneRepository;
import com.dauphinesitn.flight_service.service.FlightItineraryService;
import com.dauphinesitn.flight_service.service.FlightService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class FlightServiceImpl implements FlightService {

    private final FlightRepository flightRepository;

    private final FlightItineraryRepository flightItineraryRepository;

    private final PlaneRepository planeRepository;

    @Override
    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    @Override
    public Flight getFlightById(UUID flightId) {
        return flightRepository.findById(flightId)
                .orElseThrow(() -> new IllegalArgumentException("Flight not found with ID: " + flightId));
    }

    @Override
    public Flight createFlight(FlightDTO flightDTO) {
        FlightItineraryId flightItineraryId = new FlightItineraryId(
                flightDTO.flightItineraryDTO().departureAirportId(),
                flightDTO.flightItineraryDTO().arrivalAirportId()
        );
        FlightItinerary flightItinerary = flightItineraryRepository
                .findById(flightItineraryId)
                .orElseThrow(() -> new IllegalArgumentException("Flight itinerary not found with ID: " + flightDTO.flightItineraryDTO().arrivalAirportId() + " to " + flightDTO.flightItineraryDTO().departureAirportId()));
        Plane plane = planeRepository
                .findById(flightDTO.plane().planeId())
                .orElseThrow(() -> new IllegalArgumentException("Plane not found with ID: " + flightDTO.plane().planeId()));
        Flight flight = Flight.builder()
                .flightId(UUID.randomUUID())
                .flightItinerary(flightItinerary)
                .arrivalTime(flightDTO.arrivalTime())
                .departureTime(flightDTO.departureTime())
                .plane(plane)
                .build();
        return flightRepository.save(flight);
    }

    @Override
    public Flight updateFlight(UUID flightId, FlightDTO flight) {
        Flight existingFlight = flightRepository.findById(flightId)
                .orElseThrow(() -> new IllegalArgumentException("Flight not found with ID: " + flightId));

        FlightItineraryId flightItineraryId = new FlightItineraryId(
                flight.flightItineraryDTO().departureAirportId(),
                flight.flightItineraryDTO().arrivalAirportId()
        );
        FlightItinerary flightItinerary = flightItineraryRepository
                .findById(flightItineraryId)
                .orElseThrow(() -> new IllegalArgumentException("Flight itinerary not found with ID: " + flight.flightItineraryDTO().arrivalAirportId() + " to " + flight.flightItineraryDTO().departureAirportId()));

        Plane plane = planeRepository
                .findById(flight.plane().planeId())
                .orElseThrow(() -> new IllegalArgumentException("Plane not found with ID: " + flight.plane().planeId()));

        existingFlight.setFlightItinerary(flightItinerary);
        existingFlight.setArrivalTime(flight.arrivalTime());
        existingFlight.setDepartureTime(flight.departureTime());
        existingFlight.setPlane(plane);

        return flightRepository.save(existingFlight);
    }

    @Override
    public Flight deleteFlight(UUID flightId) {
        Flight flight = flightRepository.findById(flightId)
                .orElseThrow(() -> new IllegalArgumentException("Flight not found with ID: " + flightId));
        flightRepository.delete(flight);
        return flight;
    }
}
