package com.dauphinesitn.flight_service.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Seat {

    @EmbeddedId
    private SeatId seatId;

    private String description;

    @MapsId("planeId") // map avionId dans SeatId
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "plane_id", nullable = false)
    private Plane plane;
}
