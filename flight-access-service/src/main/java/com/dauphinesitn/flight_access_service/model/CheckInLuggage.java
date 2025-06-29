package com.dauphinesitn.flight_access_service.model;

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
public class CheckInLuggage {

    @Id
    private UUID luggageId;

    @ManyToOne
    @JoinColumn(name = "check_in_id" )
    private CheckIn checkIn;

    private double height;

    private double weight;
}
