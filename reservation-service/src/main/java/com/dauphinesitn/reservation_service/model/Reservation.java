package com.dauphinesitn.reservation_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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

    private Price price;

    @OneToOne
    private SeatInventory siegeAvailablity;

    @OneToMany(mappedBy = "reservationId")
    private List<Luggage> luggages;
}
