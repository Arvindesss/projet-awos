package com.dauphinesitn.flight_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FlightItinerary {

    @EmbeddedId
    private FlightItineraryId flightItineraryId;
}
