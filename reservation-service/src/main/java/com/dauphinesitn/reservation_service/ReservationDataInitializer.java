package com.dauphinesitn.reservation_service;

import com.dauphinesitn.reservation_service.model.Reservation;
import com.dauphinesitn.reservation_service.repository.ReservationRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ReservationDataInitializer {

    @Autowired
    private ReservationRepository reservationRepository;

    @PostConstruct
    public void init() {
        Reservation reservation1 = Reservation.builder()
                .reservationId(UUID.fromString("11111111-1111-1111-1111-111111111111"))
                .customerId(UUID.fromString("22222222-2222-2222-2222-222222222222"))
                .flightId(UUID.fromString("33333333-3333-3333-3333-333333333333"))
                .price(150.0)
                .currency("EUR")
                .reservedSeatNumber("12A")
                .status(Reservation.Status.CONFIRMED)
                .build();

        Reservation reservation2 = Reservation.builder()
                .reservationId(UUID.fromString("44444444-4444-4444-4444-444444444444"))
                .customerId(UUID.fromString("55555555-5555-5555-5555-555555555555"))
                .flightId(UUID.fromString("66666666-6666-6666-6666-666666666666"))
                .price(200.0)
                .currency("USD")
                .reservedSeatNumber("3C")
                .status(Reservation.Status.PENDING)
                .build();

        reservationRepository.save(reservation1);
        reservationRepository.save(reservation2);
    }
}
