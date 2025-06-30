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
public class City {

    @Id
    private UUID uuid;

    @Column(unique = true)
    private String name;

    private String postalCode;

    @ManyToOne
    @JoinColumn(name = "country_id", nullable = false)
    private Country country;
}
