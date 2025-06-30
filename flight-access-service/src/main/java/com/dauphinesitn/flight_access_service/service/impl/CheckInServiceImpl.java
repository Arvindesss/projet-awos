package com.dauphinesitn.flight_access_service.service.impl;

import com.dauphinesitn.flight_access_service.client.CustomerClient;
import com.dauphinesitn.flight_access_service.client.ReservationClient;
import com.dauphinesitn.flight_access_service.dto.*;
import com.dauphinesitn.flight_access_service.model.CheckIn;
import com.dauphinesitn.flight_access_service.model.CheckInLuggage;
import com.dauphinesitn.flight_access_service.repository.CheckInRepository;
import com.dauphinesitn.flight_access_service.service.CheckInService;

import com.dauphinesitn.flight_access_service.service.SeatingService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CheckInServiceImpl implements CheckInService {

    private final CheckInRepository checkInRepository;

    private final SeatingService seatingService;

    private final CustomerClient customerClient;

    private final ReservationClient reservationClient;

    @Override
    public List<CheckIn> getAllCheckIns() {
        return checkInRepository.findAll();
    }

    @Override
    public CheckIn getCheckInById(UUID id) {
        return checkInRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Check-in not found with id: " + id));
    }

    @Override
    public CheckIn createCheckIn(CheckInDTO checkIn) {
        CustomerDTO customer =  customerClient.getCustomerByCardId(checkIn.cardId());
        ReservationDTO reservation = reservationClient.getReservationById(checkIn.reservationId());
        if(!reservation.status().equals(ReservationDTO.Status.CONFIRMED)) {
            throw new RuntimeException("Cannot create check-in for a reservation that is not confirmed.");
        }
        String seatNumber = reservation.seatNumber();
        if(seatNumber == null || seatNumber.isBlank()) {
            SeatingDTO seatingDTO = SeatingDTO.builder()
                    .flightId(reservation.flightId())
                    .customerId(checkIn.customerId())
                    .build();
           seatNumber = seatingService.assignSeat(seatingDTO);
        }
        CheckIn newCheckIn = CheckIn.builder()
                .checkInId(UUID.randomUUID())
                .cardId(checkIn.cardId())
                .customerId(customer.customerId())
                .reservationId(checkIn.reservationId())
                .seatNumber(seatNumber)
                .checkInTime(LocalDateTime.now())
                .build();
        List<CheckInLuggage> luggages = checkIn.luggages().stream()
                .map(luggage -> CheckInLuggage.builder()
                        .luggageId(UUID.randomUUID())
                        .checkIn(newCheckIn)
                        .height(luggage.height())
                        .weight(luggage.weight())
                        .build())
                .toList();
        newCheckIn.setLuggages(luggages);
        return checkInRepository.save(newCheckIn);
    }

    @Override
    public CheckIn deleteCheckIn(UUID id) {
        CheckIn checkIn = getCheckInById(id);
        checkInRepository.delete(checkIn);
        return checkIn;
    }
}
