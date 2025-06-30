package com.dauphinesitn.reservation_service.dto.queryparam;

import com.dauphinesitn.reservation_service.dto.ReservationDTO;

import java.util.UUID;

public record UpdateReservationStatusRequestBody(UUID reservationId,
                                                 ReservationDTO.Status status) {
}