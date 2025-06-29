package com.dauphinesitn.inventory_service.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
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
}
