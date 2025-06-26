package com.dauphinesitn.reservation_service.mapper;

import com.dauphinesitn.reservation_service.dto.LuggageDTO;
import com.dauphinesitn.reservation_service.model.Luggage;

import java.util.List;

public class LuggageMapper {

    public static LuggageDTO toDto(Luggage luggage) {
        LuggageDTO luggageDTO = LuggageDTO.builder()
                .luggageId(luggage.getLuggageId())
                .height(luggage.getHeight())
                .weight(luggage.getWeight())
                .build();
        return luggageDTO;
    }

    public static List<LuggageDTO> toDto(List<Luggage> luggage) {
        return luggage.stream()
                .map(LuggageMapper::toDto)
                .toList();
    }

    public static Luggage toEntity(LuggageDTO luggageDTO) {
        return Luggage.builder()
                .luggageId(luggageDTO.luggageId())
                .height(luggageDTO.height())
                .weight(luggageDTO.weight())
                .build();
    }

    public static List<Luggage> toEntity(List<LuggageDTO> luggages) {
        return luggages.stream()
                .map(LuggageMapper::toEntity)
                .toList();
    }
}
