package com.dauphinesitn.flight_access_service.service.impl;

import com.dauphinesitn.flight_access_service.client.CustomerClient;
import com.dauphinesitn.flight_access_service.client.ReservationClient;
import com.dauphinesitn.flight_access_service.dto.*;
import com.dauphinesitn.flight_access_service.model.CheckIn;
import com.dauphinesitn.flight_access_service.model.CheckInLuggage;
import com.dauphinesitn.flight_access_service.repository.CheckInRepository;
import com.dauphinesitn.flight_access_service.service.CheckInService;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CheckInServiceImpl implements CheckInService {

    private final CheckInRepository checkInRepository;

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
        if(checkIn.luggages().size() > reservation.luggages().size()) {
            throw new IllegalArgumentException("Number of luggage exceeds the reservation limit.");
        }
        if(checkIn.luggages().stream().mapToDouble(CheckInLuggageDTO::weight).sum() >
                reservation.luggages().stream().mapToDouble(LuggageDTO::expectedMaxWeight).sum() ) {
            throw new IllegalArgumentException("Total luggage weight exceeds the expected amount.");
        }
        List<CheckInLuggage> luggages = checkIn.luggages().stream()
                .map(luggage -> CheckInLuggage.builder()
                        .luggageId(UUID.randomUUID())
                        .reservationId(checkIn.reservationId())
                        .height(luggage.height())
                        .weight(luggage.weight())
                        .build())
                .toList();
        CheckIn newCheckIn = CheckIn.builder()
                .checkInId(UUID.randomUUID())
                .cardId(checkIn.cardId())
                .customerId(customer.customerId())
                .reservationId(checkIn.reservationId())
                .luggages(luggages)
                .build();
        return checkInRepository.save(newCheckIn);
    }

    @Override
    public CheckIn deleteCheckIn(UUID id) {
        CheckIn checkIn = getCheckInById(id);
        checkInRepository.delete(checkIn);
        return checkIn;
    }
}
