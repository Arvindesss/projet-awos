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
        UUID checkInId = UUID.fromString("aaaaaaaa-aaaa-aaaa-aaaa-aaaaaaaaaaaa");
        CheckIn checkIn = CheckIn.builder()
                .checkInId(checkInId)
                .cardId(UUID.fromString("bbbbbbbb-bbbb-bbbb-bbbb-bbbbbbbbbbbb"))
                .customerId(UUID.fromString("cccccccc-cccc-cccc-cccc-cccccccccccc"))
                .reservationId(UUID.fromString("dddddddd-dddd-dddd-dddd-dddddddddddd"))
                .seatNumber("14B")
                .checkInTime(LocalDateTime.now().minusHours(2))
                .build();

        checkInRepository.save(checkIn);

        // Création des bagages liés au CheckIn
        CheckInLuggage luggage1 = CheckInLuggage.builder()
                .luggageId(UUID.fromString("eeeeeeee-eeee-eeee-eeee-eeeeeeeeeeee"))
                .checkIn(checkIn)
                .height(30.0)
                .weight(7.5)
                .build();

        CheckInLuggage luggage2 = CheckInLuggage.builder()
                .luggageId(UUID.fromString("ffffffff-ffff-ffff-ffff-ffffffffffff"))
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
                .boardingId(UUID.fromString("99999999-9999-9999-9999-999999999999"))
                .cardId(UUID.fromString("bbbbbbbb-bbbb-bbbb-bbbb-bbbbbbbbbbbb"))  // même cardId que checkIn
                .customerId(UUID.fromString("cccccccc-cccc-cccc-cccc-cccccccccccc")) // même customerId que checkIn
                .reservationId(UUID.fromString("dddddddd-dddd-dddd-dddd-dddddddddddd")) // même reservationId que checkIn
                .checkIn(checkIn)
                .boardingTime(LocalDateTime.now().minusMinutes(30))
                .build();

        boardingRepository.save(boarding);
    }
}
