package com.dauphinesitn.payment_service.dto;

import lombok.Builder;

import java.util.UUID;

@Builder
public record PaymentDTO(UUID paymentId,
                         UUID customerId,
                         Double amount,
                         String currency) {

}
