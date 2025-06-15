package com.dauphinesitn.flight_service.service.impl;

import com.dauphinesitn.flight_service.dto.PlaneDTO;
import com.dauphinesitn.flight_service.model.Plane;
import com.dauphinesitn.flight_service.repository.PlaneRepository;
import com.dauphinesitn.flight_service.service.PlaneService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class PlaneServiceImpl implements PlaneService {

    private final PlaneRepository planeRepository;

    @Override
    public List<Plane> getAllPlanes() {
        return planeRepository.findAll();
    }

    @Override
    public Plane getPlaneById(UUID planeId) {
        return planeRepository.findById(planeId)
                .orElseThrow(() -> new IllegalArgumentException("Plane not found with ID: " + planeId));
    }

    @Override
    public Plane createPlane(PlaneDTO planeDTO) {
        Plane newPlane = Plane.builder()
                .planeId(UUID.randomUUID())
                .model(planeDTO.model())
                .manufacturer(planeDTO.manufacturer())
                .maxCapacity(planeDTO.maxCapacity())
                .maxBaggageWeight(planeDTO.maxBaggageWeight())
                .build();
        return planeRepository.save(newPlane);
    }

    @Override
    public Plane updatePlane(UUID planeId, PlaneDTO planeDTO) {
        Plane existingPlane = planeRepository.findById(planeId)
                .orElseThrow(() -> new IllegalArgumentException("Plane not found with ID: " + planeId));

        existingPlane.setModel(planeDTO.model());
        existingPlane.setManufacturer(planeDTO.manufacturer());
        existingPlane.setMaxCapacity(planeDTO.maxCapacity());
        existingPlane.setMaxBaggageWeight(planeDTO.maxBaggageWeight());

        return planeRepository.save(existingPlane);
    }

    @Override
    public Plane deletePlane(UUID planeId) {
        Plane existingPlane = planeRepository.findById(planeId)
                .orElseThrow(() -> new IllegalArgumentException("Plane not found with ID: " + planeId));
        planeRepository.delete(existingPlane);
        return existingPlane;
    }
}
