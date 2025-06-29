package com.dauphinesitn.payment_service.dto.queryparam;

import com.dauphinesitn.payment_service.dto.ReservationDTO;
import lombok.Builder;

@Builder
public record UpdateReservationStatusRequestBody(ReservationDTO.Status status) {
}