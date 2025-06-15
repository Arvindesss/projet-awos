package com.dauphinesitn.flight_service.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.*;

import java.time.Duration;
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

    @OneToOne
    private Plane plane;

    @OneToOne
    private FlightItinerary flightItinerary;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime departureTime;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime arrivalTime;
}
