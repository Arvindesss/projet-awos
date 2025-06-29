package com.dauphinesitn.reservation_service.mapper;

import com.dauphinesitn.reservation_service.dto.ReservationDTO;
import com.dauphinesitn.reservation_service.model.Reservation;

import java.util.List;

public class ReservationMapper {

    public static ReservationDTO toDto(Reservation reservation) {
        return ReservationDTO.builder()
                .reservationId(reservation.getReservationId())
                .customerId(reservation.getCustomerId())
                .flightId(reservation.getFlightId())
                .price(reservation.getPrice())
                .currency(reservation.getCurrency())
                .seatNumber(reservation.getReservedSeatNumber())
                .status(ReservationDTO.Status.valueOf(reservation.getStatus().name()))
                .build();
    }

    public static List<ReservationDTO> toDto(List<Reservation> reservations) {
        return reservations.stream()
                .map(ReservationMapper::toDto)
                .toList();
    }
}
