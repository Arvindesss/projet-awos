package com.dauphinesitn.flight_service.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Objects;
import java.util.UUID;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SeatId {

    private UUID planeId;

    private String seatNumber;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SeatId seatId = (SeatId) o;
        return Objects.equals(planeId, seatId.planeId) &&
                Objects.equals(seatNumber, seatId.seatNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(planeId, seatNumber);
    }
}
