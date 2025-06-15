package com.dauphinesitn.flight_service.service;

import com.dauphinesitn.flight_service.dto.FlightDTO;
import com.dauphinesitn.flight_service.model.Flight;

import java.util.List;
import java.util.UUID;

public interface FlightService {

    List<Flight> getAllFlights();

    Flight getFlightById(UUID flightId);

    Flight createFlight(FlightDTO flight);

    Flight updateFlight(UUID flightId, FlightDTO flight);

    Flight deleteFlight(UUID flightId);
}
