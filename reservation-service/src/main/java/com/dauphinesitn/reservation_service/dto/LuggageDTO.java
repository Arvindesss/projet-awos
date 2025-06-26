package com.dauphinesitn.reservation_service.dto;

import lombok.Builder;

import java.util.UUID;

@Builder
public record LuggageDTO(UUID luggageId,
                         double height,
                         double weight) {
}
