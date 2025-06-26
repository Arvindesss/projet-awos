package com.dauphinesitn.reservation_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReservedLuggage {

    @Id
    private UUID luggageId;

    private double expectedMaxHeight;

    private double expectedMaxWeight;

    @ManyToOne
    @JoinColumn(name = "reservation_id")
    private Reservation reservation;
}
