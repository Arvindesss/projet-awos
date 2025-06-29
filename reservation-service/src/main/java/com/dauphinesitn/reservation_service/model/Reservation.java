package com.dauphinesitn.reservation_service.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {

    @Id
    private UUID reservationId;

    private UUID customerId;

    private UUID flightId;

    private double price;

    private String currency;

    private String reservedSeatNumber;

    @Enumerated(EnumType.STRING)
    private Status status;

    public enum Status {
        PENDING,
        CONFIRMED,
        CANCELLED
    }
}
