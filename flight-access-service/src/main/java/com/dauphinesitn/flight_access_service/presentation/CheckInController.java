package com.dauphinesitn.flight_access_service.presentation;

import com.dauphinesitn.flight_access_service.dto.CheckInDTO;
import com.dauphinesitn.flight_access_service.mapper.CheckInMapper;
import com.dauphinesitn.flight_access_service.model.CheckIn;
import com.dauphinesitn.flight_access_service.service.CheckInService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/check-ins")
@AllArgsConstructor
public class CheckInController {

    private final CheckInService checkInService;

    @GetMapping("")
    public ResponseEntity<List<CheckInDTO>> getAllCheckIns() {
        List<CheckIn> checkIns = checkInService.getAllCheckIns();
        return ResponseEntity.ok(CheckInMapper.toDTO(checkIns));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CheckInDTO> getCheckInById(@PathVariable UUID id) {
        CheckIn checkIn = checkInService.getCheckInById(id);
        return ResponseEntity.ok(CheckInMapper.toDTO(checkIn));
    }

    @PostMapping("/create")
    public ResponseEntity<CheckInDTO> createCheckIn(@RequestBody CheckInDTO checkInDTO) {
        CheckIn createdCheckIn = checkInService.createCheckIn(checkInDTO);
        return ResponseEntity.created(URI.create("/v1/check-ins/" + createdCheckIn.getCheckInId()))
                .body(CheckInMapper.toDTO(createdCheckIn));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CheckInDTO> deleteCheckIn(@PathVariable UUID id) {
        CheckIn deletedCheckIn = checkInService.deleteCheckIn(id);
        return ResponseEntity.ok(CheckInMapper.toDTO(deletedCheckIn));
    }
}
