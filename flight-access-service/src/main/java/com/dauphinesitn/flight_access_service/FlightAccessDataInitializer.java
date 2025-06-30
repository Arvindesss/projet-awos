package com.dauphinesitn.flight_access_service;

import com.dauphinesitn.flight_access_service.model.Boarding;
import com.dauphinesitn.flight_access_service.model.CheckIn;
import com.dauphinesitn.flight_access_service.model.CheckInLuggage;
import com.dauphinesitn.flight_access_service.repository.BoardingRepository;
import com.dauphinesitn.flight_access_service.repository.CheckInLuggageRepository;
import com.dauphinesitn.flight_access_service.repository.CheckInRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Component
public class FlightAccessDataInitializer {

    @Autowired
    private BoardingRepository boardingRepository;

    @Autowired
    private CheckInRepository checkInRepository;

    @Autowired
    private CheckInLuggageRepository checkInLuggageRepository;

    @PostConstruct
    public void init() {
        // Création du CheckIn
        UUID checkInId = UUID.fromString("11111111-1111-1111-1111-111111111111");
        CheckIn checkIn = CheckIn.builder()
                .checkInId(checkInId)
                .cardId(UUID.fromString("11111111-1111-1111-1111-111111111111"))
                .customerId(UUID.fromString("11111111-1111-1111-1111-111111111111"))
                .reservationId(UUID.fromString("11111111-1111-1111-1111-111111111111"))
                .seatNumber("14B")
                .checkInTime(LocalDateTime.now().minusHours(2))
                .build();

        checkInRepository.save(checkIn);

        // Création des bagages liés au CheckIn
        CheckInLuggage luggage1 = CheckInLuggage.builder()
                .luggageId(UUID.fromString("11111111-1111-1111-1111-111111111111"))
                .checkIn(checkIn)
                .height(30.0)
                .weight(7.5)
                .build();

        CheckInLuggage luggage2 = CheckInLuggage.builder()
                .luggageId(UUID.fromString("22222222-2222-2222-2222-222222222222"))
                .checkIn(checkIn)
                .height(45.0)
                .weight(12.0)
                .build();

        checkInLuggageRepository.save(luggage1);
        checkInLuggageRepository.save(luggage2);

        // Mise à jour de la liste des bagages dans CheckIn
        checkIn.setLuggages(List.of(luggage1, luggage2));
        checkInRepository.save(checkIn);

        // Création du Boarding lié au CheckIn
        Boarding boarding = Boarding.builder()
                .boardingId(UUID.fromString("11111111-1111-1111-1111-111111111111"))
                .cardId(UUID.fromString("11111111-1111-1111-1111-111111111111"))  // même cardId que checkIn
                .customerId(UUID.fromString("11111111-1111-1111-1111-111111111111")) // même customerId que checkIn
                .reservationId(UUID.fromString("11111111-1111-1111-1111-111111111111")) // même reservationId que checkIn
                .checkIn(checkIn)
                .boardingTime(LocalDateTime.now().minusMinutes(30))
                .build();

        boardingRepository.save(boarding);
    }
}
