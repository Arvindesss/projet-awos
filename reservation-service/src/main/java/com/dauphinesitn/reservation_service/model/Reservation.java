package com.dauphinesitn.reservation_service.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
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

    @Embedded
    private Price price;

    @OneToOne
    private SeatInventory siegeAvailablity;

    @OneToMany(mappedBy = "reservation")
    private List<ReservedLuggage> reservedLuggages;
}
