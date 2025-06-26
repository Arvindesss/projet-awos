package com.dauphinesitn.reservation_service.dto;

import lombok.Builder;

import java.util.UUID;

@Builder
public record CustomerDTO(UUID uuid,
                          String firstname,
                          String surname,
                          String email) {

}
