package com.dauphinesitn.customer_service.dto;

import lombok.Builder;

import java.util.UUID;

@Builder
public record CustomerDTO(UUID customerId,
                          String firstname,
                          String surname,
                          String email,
                          CardDTO cardId) {

}
