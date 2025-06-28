package com.dauphinesitn.flight_access_service.dto;

import lombok.Builder;

import java.util.UUID;

@Builder
public record ReservedLuggageDTO(UUID luggageId,
                                 double expectedMaxHeight,
                                 double expectedMaxWeight) {
}
