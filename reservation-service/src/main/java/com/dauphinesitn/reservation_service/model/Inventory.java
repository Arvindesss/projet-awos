package com.dauphinesitn.reservation_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Inventory {

    @Id
    private UUID flightId;

    @OneToMany
    private List<SeatInventory> seatInventory;

    @OneToMany
    private List<ReservedLuggage> reservedLuggages;
}
