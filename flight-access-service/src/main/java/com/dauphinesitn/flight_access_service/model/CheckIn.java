package com.dauphinesitn.flight_access_service.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;


@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CheckIn {

    @Id
    private UUID checkInId;

    private UUID cardId;

    private UUID customerId;

    @Column(unique = true)
    private UUID reservationId;

    private String seatNumber;

    @OneToMany(mappedBy = "checkIn", cascade = CascadeType.ALL)
    private List<CheckInLuggage> luggages;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime checkInTime;
}
