package com.dauphinesitn.flight_service.model;

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
public class Plane {

    @Id
    private UUID planeId;

    private String model;

    private String manufacturer;

    private int maxCapacity;

    private int maxBaggageWeight;
}
