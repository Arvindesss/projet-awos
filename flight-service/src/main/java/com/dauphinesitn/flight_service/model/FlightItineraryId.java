package com.dauphinesitn.flight_service.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FlightItineraryId {

    private UUID departureAirportId;

    private UUID arrivalAirportId;
}
