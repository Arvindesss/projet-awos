package com.dauphinesitn.search_service.dto;

import lombok.Builder;

import java.util.UUID;

@Builder
public record ItineraryPricingDTO(UUID itineraryPricingId,
                                  UUID departureAirportId,
                                  UUID arrivalAirportId,
                                  double price,
                                  String currency) {
}
