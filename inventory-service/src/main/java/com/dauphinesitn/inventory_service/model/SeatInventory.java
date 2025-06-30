package com.dauphinesitn.inventory_service.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SeatInventory {

    @EmbeddedId
    private SeatInventoryId seatInventoryId;

    private boolean isAvailable;

    @MapsId("flightId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "flight_id", nullable = false)
    private Inventory inventory;
}
