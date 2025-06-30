package com.dauphinesitn.pricing_service;

import com.dauphinesitn.pricing_service.model.ItineraryPricing;
import com.dauphinesitn.pricing_service.repository.ItineraryPricingRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class PricingDataInitializer {

    @Autowired
    private ItineraryPricingRepository itineraryPricingRepository;

    @PostConstruct
    public void init() {
        // UUIDs d'aéroport déjà créés dans le service location
        UUID cdgAirportId = UUID.fromString("11111111-1111-1111-1111-111111111111"); // remplace par le vrai UUID de CDG
        UUID orlyAirportId = UUID.fromString("22222222-2222-2222-2222-222222222222"); // autre exemple, Orly

        // Exemple d'ajout de tarifs pour des itinéraires
        ItineraryPricing pricingCdgOrly = ItineraryPricing.builder()
                .itineraryPricingId(UUID.fromString("11111111-1111-1111-1111-111111111111"))
                .departureAirportId(cdgAirportId)
                .arrivalAirportId(orlyAirportId)
                .price(50.0)
                .currency("EUR")
                .build();

        ItineraryPricing pricingOrlyCdg = ItineraryPricing.builder()
                .itineraryPricingId(UUID.fromString("22222222-2222-2222-2222-222222222222"))
                .departureAirportId(orlyAirportId)
                .arrivalAirportId(cdgAirportId)
                .price(45.0)
                .currency("EUR")
                .build();

        itineraryPricingRepository.save(pricingCdgOrly);
        itineraryPricingRepository.save(pricingOrlyCdg);
    }
}
