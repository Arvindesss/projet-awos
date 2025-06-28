package com.dauphinesitn.pricing_service.mapper;

import com.dauphinesitn.pricing_service.dto.ItineraryPricingDTO;
import com.dauphinesitn.pricing_service.model.ItineraryPricing;

public class ItineraryPricingMapper {

    public ItineraryPricingDTO toDTO(ItineraryPricing itineraryPricing) {
       return ItineraryPricingDTO.builder()
                .id(itineraryPricing.getId())
                .itineraryId(itineraryPricing.getItineraryId())
                .price(itineraryPricing.getPrice())
                .currency(itineraryPricing.getCurrency())
                .build();
    }
}
