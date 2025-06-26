package com.dauphinesitn.reservation_service.model;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Price {

    private UUID currencyId;

    private double amount;
}
