package com.dauphinesitn.flight_access_service.presentation;

import com.dauphinesitn.flight_access_service.dto.BoardingDTO;
import com.dauphinesitn.flight_access_service.mapper.BoardingMapper;
import com.dauphinesitn.flight_access_service.model.Boarding;
import com.dauphinesitn.flight_access_service.service.BoardingService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/boardings")
@AllArgsConstructor
public class BoardingController {

    private final BoardingService boardingService;

    @GetMapping("")
    public ResponseEntity<List<BoardingDTO>> getAllBoardings() {
        List<Boarding> boardings = boardingService.getAllBoardings();
        return ResponseEntity.ok(BoardingMapper.toDTO(boardings));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BoardingDTO> getBoardingById(@PathVariable UUID id) {
        Boarding checkIn = boardingService.getBoardingById(id);
        return ResponseEntity.ok(BoardingMapper.toDTO(checkIn));
    }

    @PostMapping("/create")
    public ResponseEntity<BoardingDTO> createBoarding(@RequestBody BoardingDTO checkInDTO) {
        Boarding createdBoarding = boardingService.createBoarding(checkInDTO);
        return ResponseEntity.ok(BoardingMapper.toDTO(createdBoarding));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BoardingDTO> deleteBoarding(@PathVariable UUID id) {
        Boarding deletedBoarding = boardingService.deleteBoarding(id);
        return ResponseEntity.ok(BoardingMapper.toDTO(deletedBoarding));
    }
}
