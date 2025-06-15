package com.dauphinesitn.flight_service.dto.converter;

import com.dauphinesitn.flight_service.dto.PlaneDTO;
import com.dauphinesitn.flight_service.model.Plane;

import java.util.List;

public class PlaneToPlaneDTOConverter {
    public static PlaneDTO convert(Plane plane) {
        return PlaneDTO.builder()
                .planeId(plane.getPlaneId())
                .model(plane.getModel())
                .manufacturer(plane.getManufacturer())
                .maxCapacity(plane.getMaxCapacity())
                .maxBaggageWeight(plane.getMaxBaggageWeight())
                .build();
    }

    public static List<PlaneDTO> convert(List<Plane> planes) {
        return planes.stream()
                .map(PlaneToPlaneDTOConverter::convert)
                .toList();
    }
}
