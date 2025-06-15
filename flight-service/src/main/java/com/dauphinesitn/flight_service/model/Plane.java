package com.dauphinesitn.flight_service.model;

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
public class Plane {

    @Id
    private UUID planeId;

    private String model;

    private String manufacturer;

    @OneToMany(mappedBy = "plane")
    private List<Seat> seats;

    private int maxCapacity;

    private int maxBaggageWeight;
}
