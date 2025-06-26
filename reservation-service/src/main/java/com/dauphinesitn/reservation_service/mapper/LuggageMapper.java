package com.dauphinesitn.reservation_service.mapper;

import com.dauphinesitn.reservation_service.dto.ReservedLuggageDTO;
import com.dauphinesitn.reservation_service.model.ReservedLuggage;

import java.util.List;

public class LuggageMapper {

    public static ReservedLuggageDTO toDto(ReservedLuggage reservedLuggage) {
        ReservedLuggageDTO reservedLuggageDTO = ReservedLuggageDTO.builder()
                .luggageId(reservedLuggage.getLuggageId())
                .expectedMaxHeight(reservedLuggage.getExpectedMaxHeight())
                .expectedMaxWeight(reservedLuggage.getExpectedMaxWeight())
                .build();
        return reservedLuggageDTO;
    }

    public static List<ReservedLuggageDTO> toDto(List<ReservedLuggage> reservedLuggage) {
        return reservedLuggage.stream()
                .map(LuggageMapper::toDto)
                .toList();
    }

    public static ReservedLuggage toEntity(ReservedLuggageDTO reservedLuggageDTO) {
        return ReservedLuggage.builder()
                .luggageId(reservedLuggageDTO.luggageId())
                .expectedMaxHeight(reservedLuggageDTO.expectedMaxHeight())
                .expectedMaxWeight(reservedLuggageDTO.expectedMaxWeight())
                .build();
    }

    public static List<ReservedLuggage> toEntity(List<ReservedLuggageDTO> luggages) {
        return luggages.stream()
                .map(LuggageMapper::toEntity)
                .toList();
    }
}
