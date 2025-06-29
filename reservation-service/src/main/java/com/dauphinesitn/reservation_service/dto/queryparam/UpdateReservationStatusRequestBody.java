package com.dauphinesitn.reservation_service.dto.queryparam;

import com.dauphinesitn.reservation_service.dto.ReservationDTO;

public record UpdateReservationStatusRequestBody(ReservationDTO.Status status) {
}