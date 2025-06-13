package com.dauphinesitn.location_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Airport {

    @Id
    private UUID airportId;

    private String name;

    @OneToOne
    private City city;

    @OneToOne
    private Country country;
}
