package com.dauphinesitn.pricing_service.service.impl;

import com.dauphinesitn.pricing_service.client.AirportClient;
import com.dauphinesitn.pricing_service.dto.AirportDTOResponse;
import com.dauphinesitn.pricing_service.dto.ItineraryPricingDTO;
import com.dauphinesitn.pricing_service.model.ItineraryPricing;
import com.dauphinesitn.pricing_service.repository.ItineraryPricingRepository;
import com.dauphinesitn.pricing_service.service.ItineraryPricingService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ItineraryPricingServiceImpl implements ItineraryPricingService {

    private final ItineraryPricingRepository itineraryPricingRepository;

    private final AirportClient airportClient;

    @Override
    public List<ItineraryPricing> getAllItineraryPricings() {
        return itineraryPricingRepository.findAll();
    }

    @Override
    public ItineraryPricing getItineraryPricingById(UUID id) {
        return itineraryPricingRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Itinerary Pricing not found with ID: " + id));

    }

    @Override
    public ItineraryPricing getItineraryPricingByAirportIds(UUID arrivalAirportId, UUID departureAirportId) {
        return itineraryPricingRepository.findByArrivalAirportIdAndDepartureAirportId(arrivalAirportId, departureAirportId)
                .orElseThrow(() -> new IllegalArgumentException("Itinerary Pricing not found for the given airport IDs"));
    }

    @Override
    public ItineraryPricing createItineraryPricing(ItineraryPricingDTO itineraryPricing) {
        AirportDTOResponse departureAirport = airportClient.getAirportById(itineraryPricing.departureAirportId()).getBody();
        AirportDTOResponse arrivalAirport = airportClient.getAirportById(itineraryPricing.arrivalAirportId()).getBody();
        ItineraryPricing newItineraryPricing = ItineraryPricing.builder()
                .itineraryPricingId(UUID.randomUUID())
                .departureAirportId(itineraryPricing.departureAirportId())
                .arrivalAirportId(itineraryPricing.arrivalAirportId())
                .price(itineraryPricing.price())
                .currency(itineraryPricing.currency())
                .build();
        return itineraryPricingRepository.save(newItineraryPricing);
    }

    @Override
public ItineraryPricing updateItineraryPricing(UUID id, ItineraryPricingDTO updatedPricing) {
        ItineraryPricing existingPricing = itineraryPricingRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Itinerary Pricing not found"));
        existingPricing.setDepartureAirportId(updatedPricing.departureAirportId());
        existingPricing.setArrivalAirportId(updatedPricing.arrivalAirportId());
        existingPricing.setPrice(updatedPricing.price());
        return itineraryPricingRepository.save(existingPricing);
    }

    @Override
    public ItineraryPricing deleteItineraryPricing(UUID id) {
        ItineraryPricing existingPricing = itineraryPricingRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Itinerary Pricing not found"));
        itineraryPricingRepository.delete(existingPricing);
        return existingPricing;
    }
}