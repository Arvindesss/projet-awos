package com.dauphinesitn.flight_access_service.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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
public class Boarding {

    @Id
    private UUID boardingId;

    private UUID cardId;

    private UUID customerId;

    private UUID reservationId;

    @OneToOne
    @JoinColumn(name = "check_in_id")
    private CheckIn checkIn;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime boardingTime;

}
