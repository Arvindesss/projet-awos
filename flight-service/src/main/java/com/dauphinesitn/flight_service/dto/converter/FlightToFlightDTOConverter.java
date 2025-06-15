package com.dauphinesitn.flight_service.dto.converter;

import com.dauphinesitn.flight_service.dto.FlightDTO;
import com.dauphinesitn.flight_service.model.Flight;

import java.util.List;
import java.util.stream.Collectors;

public class FlightToFlightDTOConverter {

    public static FlightDTO convert(Flight flight) {
        return FlightDTO.builder()
                .flightId(flight.getFlightId())
                .plane(PlaneToPlaneDTOConverter.convert(flight.getPlane()))
                .flightItineraryDTO(FlightItineraryToFlightItineraryDTOConverter.convert(flight.getFlightItinerary()))
                .departureTime(flight.getDepartureTime())
                .arrivalTime(flight.getArrivalTime())
                .build();
    }

    public static List<FlightDTO> convert(List<Flight> flights) {
        return flights.stream()
                .map(FlightToFlightDTOConverter::convert)
                .collect(Collectors.toList());
    }
}
