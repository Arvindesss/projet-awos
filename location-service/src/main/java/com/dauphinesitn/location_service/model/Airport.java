package com.dauphinesitn.location_service.model;

import jakarta.persistence.*;
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

    @Column(unique = true)
    private String name;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;
}
