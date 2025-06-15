package com.dauphinesitn.flight_service.presentation;

import com.dauphinesitn.flight_service.dto.PlaneDTO;
import com.dauphinesitn.flight_service.dto.converter.PlaneToPlaneDTOConverter;
import com.dauphinesitn.flight_service.model.Plane;
import com.dauphinesitn.flight_service.service.PlaneService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/planes")
@AllArgsConstructor
public class PlaneController {

    private final PlaneService planeService;

    @GetMapping("/")
    public ResponseEntity<List<PlaneDTO>> getAllPlanes() {
        List<Plane> planes = planeService.getAllPlanes();
        return ResponseEntity.ok(PlaneToPlaneDTOConverter.convert(planes));
    }

    @GetMapping("/{planeId}")
    public ResponseEntity<PlaneDTO> getPlaneById(UUID planeId) {
        Plane plane = planeService.getPlaneById(planeId);
        return ResponseEntity.ok(PlaneToPlaneDTOConverter.convert(plane));
    }

    @PostMapping("/create")
    public ResponseEntity<PlaneDTO> createPlane(PlaneDTO planeDTO) {
        Plane plane = planeService.createPlane(planeDTO);
        return ResponseEntity.ok(PlaneToPlaneDTOConverter.convert(plane));
    }

    @PutMapping("/update/{planeId}")
    public ResponseEntity<PlaneDTO> updatePlane(UUID planeId, PlaneDTO planeDTO) {
        Plane plane = planeService.updatePlane(planeId, planeDTO);
        return ResponseEntity.ok(PlaneToPlaneDTOConverter.convert(plane));
    }

    @DeleteMapping("/delete/{planeId}")
    public ResponseEntity<PlaneDTO> deletePlane(UUID planeId) {
        Plane plane = planeService.deletePlane(planeId);
        return ResponseEntity.ok(PlaneToPlaneDTOConverter.convert(plane));
    }
}
