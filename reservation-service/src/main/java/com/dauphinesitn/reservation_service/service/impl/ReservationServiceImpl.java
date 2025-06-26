package com.dauphinesitn.reservation_service.service.impl;

import com.dauphinesitn.reservation_service.dto.ReservationDTO;
import com.dauphinesitn.reservation_service.mapper.PriceMapper;
import com.dauphinesitn.reservation_service.mapper.SeatInventoryMapper;
import com.dauphinesitn.reservation_service.model.Reservation;
import com.dauphinesitn.reservation_service.repository.ReservationRepository;
import com.dauphinesitn.reservation_service.service.ReservationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;


    @Override
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation getReservationById(UUID reservationId) {
        return reservationRepository.findById(reservationId)
                .orElseThrow(() -> new IllegalArgumentException("Reservation not found for ID: " + reservationId));
    }

    @Override
    public Reservation createReservation(ReservationDTO reservation) {
        Reservation newReservation = Reservation.builder()
                .reservationId(UUID.randomUUID())
                .customerId(reservation.customerId())
                .flightId(reservation.flightId())
                .price(PriceMapper.toEntity(reservation.price()))
                .siegeAvailablity(SeatInventoryMapper.toEntity(reservation.seatAvailability()))
                .build();
        return reservationRepository.save(newReservation);
    }

    @Override
    public Reservation updateReservation(UUID reservationId, Reservation reservation) {
        Reservation existingReservation = reservationRepository.findById(reservationId)
                .orElseThrow(() -> new IllegalArgumentException("Reservation not found for ID: " + reservationId));
        existingReservation.setCustomerId(reservation.getCustomerId());
        existingReservation.setFlightId(reservation.getFlightId());
        existingReservation.setPrice(reservation.getPrice());
        existingReservation.setSiegeAvailablity(reservation.getSiegeAvailablity());
        return reservationRepository.save(existingReservation);
    }

    @Override
    public Reservation deleteReservation(UUID reservationId) {
        Reservation reservation = reservationRepository.findById(reservationId)
                .orElseThrow(() -> new IllegalArgumentException("Reservation not found for ID: " + reservationId));
        reservationRepository.delete(reservation);
        return reservation;
    }
}
