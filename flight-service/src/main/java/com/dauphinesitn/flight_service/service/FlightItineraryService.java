package com.dauphinesitn.flight_service.service;

import com.dauphinesitn.flight_service.dto.FlightItineraryCompleteDTO;
import com.dauphinesitn.flight_service.dto.FlightItineraryDTO;
import com.dauphinesitn.flight_service.model.FlightItinerary;

import java.util.List;
import java.util.UUID;

public interface FlightItineraryService {

    List<FlightItinerary> getAllFlightItineraries();

    FlightItineraryCompleteDTO getFlightItineraryById(FlightItineraryDTO flightItinerary);

    FlightItinerary createFlightItinerary(FlightItineraryDTO flightItinerary);

    FlightItinerary deleteFlightItinerary(UUID flightItineraryId);
}
