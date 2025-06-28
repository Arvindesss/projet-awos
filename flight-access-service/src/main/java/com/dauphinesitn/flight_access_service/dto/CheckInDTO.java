package com.dauphinesitn.flight_access_service.dto;

import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Builder
public record CheckInDTO (UUID checkInId,
                          UUID cardId,
                          UUID customerId,
                          UUID reservationId,
                          UUID seatInventoryId,
                          LocalDateTime checkInTime,
                          List<CheckInLuggageDTO> luggages) {
}
