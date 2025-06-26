package com.dauphinesitn.reservation_service.dto;

import lombok.Builder;

import java.util.UUID;

@Builder
public record PriceDTO(UUID currencyId,
                       double amount){
}
