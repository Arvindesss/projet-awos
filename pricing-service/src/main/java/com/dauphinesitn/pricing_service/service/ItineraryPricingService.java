package com.dauphinesitn.pricing_service.service;

import com.dauphinesitn.pricing_service.dto.ItineraryPricingDTO;
import com.dauphinesitn.pricing_service.model.ItineraryPricing;

import java.util.List;
import java.util.UUID;

public interface ItineraryPricingService {

    List<ItineraryPricing> getAllItineraryPricings();

    ItineraryPricing getItineraryPricingById(UUID id);

    ItineraryPricing getItineraryPricingByAirportIds(UUID arrivalAirportId, UUID departureAirportId);

    ItineraryPricing createItineraryPricing(ItineraryPricingDTO itineraryPricing);

    ItineraryPricing updateItineraryPricing(UUID id, ItineraryPricingDTO updatedPricing);

    ItineraryPricing deleteItineraryPricing(UUID id);
}
