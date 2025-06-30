package com.dauphinesitn.payment_service.dto.queryparam;

import com.dauphinesitn.payment_service.dto.ReservationDTO;
import lombok.Builder;

import java.util.UUID;

@Builder
public record UpdateReservationStatusRequestBody(UUID reservationId,
                                                 ReservationDTO.Status status) {
}