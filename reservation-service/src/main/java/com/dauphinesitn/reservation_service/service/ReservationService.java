package com.dauphinesitn.reservation_service.service;

import com.dauphinesitn.reservation_service.dto.ReservationDTO;
import com.dauphinesitn.reservation_service.model.Reservation;

import java.util.List;
import java.util.UUID;

public interface ReservationService {

    List<Reservation> getAllReservations();

    Reservation getReservationById(UUID reservationId);

    Reservation createReservation(ReservationDTO reservation);

    Reservation updateReservation(UUID reservationId, Reservation reservation);

    Reservation deleteReservation(UUID reservationId);
}
