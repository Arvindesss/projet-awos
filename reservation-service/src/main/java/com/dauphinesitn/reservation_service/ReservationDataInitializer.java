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

    }
}
