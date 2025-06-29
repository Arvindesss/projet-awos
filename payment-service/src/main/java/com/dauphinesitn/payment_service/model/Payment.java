package com.dauphinesitn.payment_service.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

    @Id
    private UUID paymentId;

    private UUID customerId;

    private String description;

    private double amount;

    private String currency;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime paymentDate;
}
