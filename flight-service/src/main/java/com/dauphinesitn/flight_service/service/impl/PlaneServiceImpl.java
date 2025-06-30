package com.dauphinesitn.flight_service.service.impl;

import com.dauphinesitn.flight_service.dto.PlaneDTO;
import com.dauphinesitn.flight_service.model.Plane;
import com.dauphinesitn.flight_service.model.Seat;
import com.dauphinesitn.flight_service.model.SeatId;
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
        UUID planeId = UUID.randomUUID();
        Plane newPlane = Plane.builder()
                .planeId(planeId)
                .model(planeDTO.model())
                .manufacturer(planeDTO.manufacturer())
                .maxBaggageWeight(planeDTO.maxBaggageWeight())
                .build();
        List<Seat> seats = planeDTO.seats().stream()
                .map(seatDTO -> Seat.builder()
                        .seatId(new SeatId(planeId, seatDTO.seatNumber()))
                        .description(seatDTO.description())
                        .plane(newPlane)
                        .build())
                .toList();
        newPlane.setSeats(seats);
        newPlane.setMaxCapacity(seats.size());
        return planeRepository.save(newPlane);
    }

    @Override
    public Plane updatePlane(UUID planeId, PlaneDTO planeDTO) {
        Plane existingPlane = planeRepository.findById(planeId)
                .orElseThrow(() -> new IllegalArgumentException("Plane not found with ID: " + planeId));

        List<Seat> seats = planeDTO.seats().stream()
                .map(seatDTO -> Seat.builder()
                        .seatId(new SeatId(planeDTO.planeId(), seatDTO.seatNumber()))
                        .description(seatDTO.description())
                        .build())
                .toList();

        existingPlane.setModel(planeDTO.model());
        existingPlane.setManufacturer(planeDTO.manufacturer());
        existingPlane.setSeats(seats);
        existingPlane.setMaxCapacity(seats.size());
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
