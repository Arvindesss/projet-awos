package com.dauphinesitn.flight_service.dto.converter;

import com.dauphinesitn.flight_service.dto.FlightItineraryDTO;
import com.dauphinesitn.flight_service.model.FlightItinerary;

import java.util.List;

public class FlightItineraryToFlightItineraryDTOConverter {

     public static FlightItineraryDTO convert(com.dauphinesitn.flight_service.model.FlightItinerary flightItinerary) {
         return FlightItineraryDTO.builder()
                 .departureAirportId(flightItinerary.getFlightItineraryId().getDepartureAirportId())
                 .arrivalAirportId(flightItinerary.getFlightItineraryId().getArrivalAirportId())
                 .build();
     }

public static List<FlightItineraryDTO> convert(List<FlightItinerary> flightItineraries) {
         return flightItineraries.stream()
                 .map(FlightItineraryToFlightItineraryDTOConverter::convert)
                 .toList();
     }
}
