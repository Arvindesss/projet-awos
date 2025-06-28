package com.dauphinesitn.flight_access_service.mapper;

import com.dauphinesitn.flight_access_service.dto.BoardingDTO;
import com.dauphinesitn.flight_access_service.model.Boarding;

import java.util.List;

public class BoardingMapper {
    public static BoardingDTO toDTO(Boarding boarding) {
        return BoardingDTO.builder()
                .boardingId(boarding.getBoardingId())
                .customerId(boarding.getCustomerId())
                .reservationId(boarding.getReservationId())
                .boardingTime(boarding.getBoardingTime())
                .build();
    }

    public static List<BoardingDTO> toDTO(List<Boarding> checkIn) {
        return checkIn.stream()
                .map(BoardingMapper::toDTO)
                .toList();
    }

    public static Boarding toEntity(BoardingDTO boardingDTO) {
        return Boarding.builder()
                .boardingId(boardingDTO.boardingId())
                .customerId(boardingDTO.customerId())
                .reservationId(boardingDTO.reservationId())
                .boardingTime(boardingDTO.boardingTime())
                .build();
    }
}
