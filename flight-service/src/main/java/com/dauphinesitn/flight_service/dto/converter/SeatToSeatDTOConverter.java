package com.dauphinesitn.flight_service.dto.converter;

import com.dauphinesitn.flight_service.dto.SeatDTO;
import com.dauphinesitn.flight_service.model.Seat;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class SeatToSeatDTOConverter {

    public static SeatDTO convert(Seat seat) {
        return SeatDTO.builder()
                .planeId(seat.getSeatId().getPlaneId())
                .seatNumber(seat.getSeatId().getSeatNumber())
                .description(seat.getDescription())
                .build();
    }

    public static List<SeatDTO> convert(List<Seat> seats) {
        return seats.stream()
                .map(SeatToSeatDTOConverter::convert)
                .toList();
    }
}
