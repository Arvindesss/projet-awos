package com.dauphinesitn.flight_access_service.mapper;

import com.dauphinesitn.flight_access_service.dto.CheckInLuggageDTO;
import com.dauphinesitn.flight_access_service.model.CheckInLuggage;

import java.util.List;

public class CheckInLuggageMapper {

    public static CheckInLuggageDTO toDTO(CheckInLuggage checkInLuggage) {
        return CheckInLuggageDTO.builder()
                .luggageId(checkInLuggage.getLuggageId())
                .weight(checkInLuggage.getWeight())
                .build();
    }

    public static List<CheckInLuggageDTO> toDTO(List<CheckInLuggage> checkInLuggages) {
        return checkInLuggages.stream()
                .map(CheckInLuggageMapper::toDTO)
                .toList();
    }
}
