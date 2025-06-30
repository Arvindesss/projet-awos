package com.dauphinesitn.flight_access_service.mapper;

import com.dauphinesitn.flight_access_service.dto.BoardingDTO;
import com.dauphinesitn.flight_access_service.model.Boarding;

import java.util.List;

public class BoardingMapper {
    public static BoardingDTO toDTO(Boarding boarding) {
        return BoardingDTO.builder()
                .boardingId(boarding.getBoardingId())
                .cardId(boarding.getCardId())
                .customerId(boarding.getCustomerId())
                .reservationId(boarding.getReservationId())
                .checkIn(CheckInMapper.toDTO(boarding.getCheckIn()))
                .boardingTime(boarding.getBoardingTime())
                .build();
    }

    public static List<BoardingDTO> toDTO(List<Boarding> checkIn) {
        return checkIn.stream()
                .map(BoardingMapper::toDTO)
                .toList();
    }
}
