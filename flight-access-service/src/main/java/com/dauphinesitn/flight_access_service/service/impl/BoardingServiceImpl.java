package com.dauphinesitn.flight_access_service.service.impl;

import com.dauphinesitn.flight_access_service.client.CustomerClient;
import com.dauphinesitn.flight_access_service.client.ReservationClient;
import com.dauphinesitn.flight_access_service.dto.BoardingDTO;
import com.dauphinesitn.flight_access_service.dto.CustomerDTO;
import com.dauphinesitn.flight_access_service.dto.ReservationDTO;
import com.dauphinesitn.flight_access_service.model.Boarding;
import com.dauphinesitn.flight_access_service.model.CheckIn;
import com.dauphinesitn.flight_access_service.repository.BoardingRepository;
import com.dauphinesitn.flight_access_service.repository.CheckInRepository;
import com.dauphinesitn.flight_access_service.service.BoardingService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class BoardingServiceImpl implements BoardingService {

    private final BoardingRepository boardingRepository;

    private final CheckInRepository checkInRepository;

    private final CustomerClient customerClient;

    private final ReservationClient reservationClient;

    @Override
    public List<Boarding> getAllBoardings() {
        return boardingRepository.findAll();
    }

    @Override
    public Boarding getBoardingById(UUID id) {
        return boardingRepository.findById(id).orElse(null);
    }

    @Override
    public Boarding createBoarding(BoardingDTO boardingDTO) {
        CustomerDTO customer = customerClient.getCustomerByCardId(boardingDTO.cardId());
        ReservationDTO reservation = reservationClient.getReservationById(boardingDTO.reservationId());
        CheckIn checkIn = checkInRepository.findByReservationId(boardingDTO.reservationId())
                .orElseThrow(() -> new IllegalArgumentException("Check-in not found for reservation ID: " + boardingDTO.reservationId()));
        Boarding boarding = Boarding.builder()
                .boardingId(UUID.randomUUID())
                .cardId(boardingDTO.cardId())
                .customerId(customer.customerId())
                .reservationId(reservation.reservationId())
                .checkIn(checkIn)
                .boardingTime(boardingDTO.boardingTime())
                .build();
        return boardingRepository.save(boarding);
    }

    @Override
    public Boarding deleteBoarding(UUID id) {
        Boarding boarding = boardingRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Boarding not found with id: " + id));
        boardingRepository.delete(boarding);
        return boarding;
    }
}
