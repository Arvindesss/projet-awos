package com.dauphinesitn.flight_service.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Flight {

    @Id
    private UUID flightId;

    @ManyToOne
    @JoinColumn(name = "plane_id", nullable = false)
    private Plane plane;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "departure_airport_id", referencedColumnName = "departureAirportId"),
            @JoinColumn(name = "arrival_airport_id", referencedColumnName = "arrivalAirportId")
    })
    private FlightItinerary flightItinerary;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime departureTime;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime arrivalTime;
}
