package com.dauphinesitn.pricing_service.dto;

import lombok.Builder;

import java.util.List;
import java.util.UUID;

@Builder
public record PlaneDTO(UUID planeId,
                       String model,
                       String manufacturer,
                       List<SeatDTO> seats,
                       int maxCapacity,
                       int maxBaggageWeight) {

}
