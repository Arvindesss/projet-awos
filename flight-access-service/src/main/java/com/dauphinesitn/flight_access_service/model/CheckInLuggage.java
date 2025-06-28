package com.dauphinesitn.flight_access_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CheckInLuggage {

    @Id
    private UUID luggageId;

    private UUID reservationId;

    private double height;

    private double weight;
}
