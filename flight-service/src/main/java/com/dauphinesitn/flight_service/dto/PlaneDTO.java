package com.dauphinesitn.flight_service.dto;

import lombok.Builder;

import java.util.UUID;


@Builder
public record PlaneDTO (UUID planeId,
                        String model,
                        String manufacturer,
                        int maxCapacity,
                        int maxBaggageWeight) {

}
