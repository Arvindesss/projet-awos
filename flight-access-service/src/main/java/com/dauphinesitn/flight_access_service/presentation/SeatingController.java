package com.dauphinesitn.flight_access_service.presentation;

import com.dauphinesitn.flight_access_service.dto.SeatingDTO;
import com.dauphinesitn.flight_access_service.service.SeatingService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/seating")
@AllArgsConstructor()
public class SeatingController {

    private final SeatingService seatingService;

    @PatchMapping("/assign-seat/")
    public ResponseEntity<Void> assignSeat(@RequestBody SeatingDTO seatingDTO) {
        seatingService.assignSeat(seatingDTO);
        return ResponseEntity.ok().build();
    }

}
