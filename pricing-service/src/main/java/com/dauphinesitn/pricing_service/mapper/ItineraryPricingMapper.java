package com.dauphinesitn.pricing_service.mapper;

import com.dauphinesitn.pricing_service.dto.ItineraryPricingDTO;
import com.dauphinesitn.pricing_service.model.ItineraryPricing;

import java.util.List;

public class ItineraryPricingMapper {

    public static ItineraryPricingDTO toDTO(ItineraryPricing itineraryPricing) {
       return ItineraryPricingDTO.builder()
                .itineraryPricingId(itineraryPricing.getItineraryPricingId())
                .departureAirportId(itineraryPricing.getDepartureAirportId())
                .arrivalAirportId(itineraryPricing.getArrivalAirportId())
                .price(itineraryPricing.getPrice())
               .currency(itineraryPricing.getCurrency())
                .build();
    }

    public static List<ItineraryPricingDTO> toDTO(List<ItineraryPricing> itineraryPricings) {
        return itineraryPricings.stream()
                .map(ItineraryPricingMapper::toDTO)
                .toList();
    }
}
