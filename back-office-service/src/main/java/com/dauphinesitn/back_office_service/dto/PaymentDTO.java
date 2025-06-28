package com.dauphinesitn.back_office_service.dto;

import lombok.Builder;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
public record PaymentDTO(UUID paymentId,
                         UUID customerId,
                         Double amount,
                         String currency,
                         LocalDateTime paymentDate) {

}
