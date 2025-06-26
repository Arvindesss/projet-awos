package com.dauphinesitn.reservation_service.model;

import jakarta.persistence.Entity;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Luggage {

    private UUID luggageId;

    private UUID reservationId;

    private double height;

    private double weight;
}
