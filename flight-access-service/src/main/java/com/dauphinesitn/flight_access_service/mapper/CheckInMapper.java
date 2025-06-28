package com.dauphinesitn.flight_access_service.mapper;

import com.dauphinesitn.flight_access_service.dto.CheckInDTO;
import com.dauphinesitn.flight_access_service.model.CheckIn;
import com.dauphinesitn.flight_access_service.model.CheckInLuggage;

import java.util.List;

public class CheckInMapper {

    public static CheckInDTO toDTO(CheckIn checkIn) {
        return CheckInDTO.builder()
                .checkInId(checkIn.getCheckInId())
                .customerId(checkIn.getCustomerId())
                .reservationId(checkIn.getReservationId())
                .luggages(CheckInLuggageMapper.toDTO(checkIn.getLuggages()))
                .checkInTime(checkIn.getCheckInTime())
                .build();
    }

    public static List<CheckInDTO> toDTO(List<CheckIn> checkIn) {
        return checkIn.stream()
                .map(CheckInMapper::toDTO)
                .toList();
    }
}
