package com.dauphinesitn.search_service.services.impl;

import com.dauphinesitn.search_service.client.FlightClient;
import com.dauphinesitn.search_service.client.LocationClient;
import com.dauphinesitn.search_service.client.PricingClient;
import com.dauphinesitn.search_service.dto.*;
import com.dauphinesitn.search_service.services.FlightSearchService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FlightSearchServiceImpl implements FlightSearchService {

    private FlightClient flightClient;

    private PricingClient pricingClient;

    private LocationClient locationClient;

    @Override
    public List<FlightSearchResult> searchFlights(FlightSearchParameters flightSearchParameters) {
        List<FlightDTO> flightSearchResults = flightClient.getAllFlights().getBody();
        ItineraryPricingDTO itineraryPricingDTO = ItineraryPricingDTO.builder()
                .departureAirportId(flightSearchParameters.departureAirportId())
                .arrivalAirportId(flightSearchParameters.arrivalAirportId())
                .build();

        return flightSearchResults.stream()
                // Filtrer par aéroports
                .filter(flight -> flightSearchParameters.arrivalAirportId() == null ||
                        flight.flightItineraryDTO().departureAirportId().equals(flightSearchParameters.arrivalAirportId()))
                .filter(flight -> flightSearchParameters.departureAirportId() == null ||
                        flight.flightItineraryDTO().arrivalAirportId().equals(flightSearchParameters.departureAirportId()))
                // Filtrer par date
                .filter(flight -> flightSearchParameters.departureDate() == null ||
                        flight.departureTime().toLocalDate().equals(flightSearchParameters.departureDate()))
                // Filtrer par prix
                .filter(flight -> flightSearchParameters.maxPrice() == null ||
                        pricingClient.getItineraryPricingByAirportIds(itineraryPricingDTO).getBody()
                                .price() <= flightSearchParameters.maxPrice())
                // Enrichir
                .map(this::buildSearchResult)
                .toList();
    }

    private FlightSearchResult buildSearchResult(FlightDTO flight) {
        AirportDTO arrAirport = locationClient.getAirportById(flight.flightItineraryDTO().arrivalAirportId()).getBody();
        AirportDTO depAirport = locationClient.getAirportById(flight.flightItineraryDTO().departureAirportId()).getBody();

        return FlightSearchResult.builder()
                .flightId(flight.flightId())
                .plane(flight.plane())
                .departureAirport(depAirport)
                .arrivalAirport(arrAirport)
                .departureTime(flight.departureTime())
                .arrivalTime(flight.arrivalTime())
                .build();
    }
}
