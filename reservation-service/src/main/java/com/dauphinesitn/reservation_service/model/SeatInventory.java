package com.dauphinesitn.reservation_service.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.*;

import java.util.UUID;

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
