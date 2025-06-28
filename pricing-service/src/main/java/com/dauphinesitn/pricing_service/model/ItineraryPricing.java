package com.dauphinesitn.pricing_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItineraryPricing {

    @Id
    private UUID itineraryPricingId;

    private UUID departureAirportId;

    private UUID arrivalAirportId;

    private double price;

    private String currency;
}
