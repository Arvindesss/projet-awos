package com.dauphinesitn.flight_service.service;

import com.dauphinesitn.flight_service.dto.PlaneDTO;
import com.dauphinesitn.flight_service.model.Plane;

import java.util.List;
import java.util.UUID;

public interface PlaneService {

    List<Plane> getAllPlanes();

    Plane getPlaneById(UUID planeId);

    Plane createPlane(PlaneDTO plane);

    Plane updatePlane(UUID planeId, PlaneDTO planeDTO);

    Plane deletePlane(UUID planeId);
}
