package com.dauphinesitn.payment_service.dto;

import lombok.Builder;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
public record PaymentDTO(UUID paymentId,
                         UUID customerId,
                         String description,
                         Double amount,
                         String currency,
                         LocalDateTime paymentDate) {

}
