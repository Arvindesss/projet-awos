package com.dauphinesitn.reservation_service.presentation;

import com.dauphinesitn.reservation_service.dto.ReservationDTO;
import com.dauphinesitn.reservation_service.dto.queryparam.UpdateReservationStatusRequestBody;
import com.dauphinesitn.reservation_service.mapper.ReservationMapper;
import com.dauphinesitn.reservation_service.model.Reservation;
import com.dauphinesitn.reservation_service.service.ReservationService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/reservations")
@AllArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;

    @GetMapping("/")
    public ResponseEntity<List<ReservationDTO>> getAllReservations() {
        List<Reservation> reservations = reservationService.getAllReservations();
        return ResponseEntity.ok(ReservationMapper.toDto(reservations));
    }

    @GetMapping("/{reservationId}")
    public ResponseEntity<ReservationDTO> getReservationById(@PathVariable UUID reservationId) {
        Reservation reservation = reservationService.getReservationById(reservationId);
        return ResponseEntity.ok(ReservationMapper.toDto(reservation));
    }

    @PostMapping("/create")
    public ResponseEntity<ReservationDTO> createReservation(@RequestBody ReservationDTO reservationDTO) {
        Reservation reservation = reservationService.createReservation(reservationDTO);
        return ResponseEntity.created(URI.create("/v1/reservations/" + reservation.getReservationId()))
                .body(ReservationMapper.toDto(reservation));
    }

    @PutMapping("/update/{reservationId}")
    public ResponseEntity<ReservationDTO> updateReservation(@PathVariable UUID reservationId, @RequestBody ReservationDTO reservation) {
        Reservation updatedReservation = reservationService.updateReservation(reservationId, reservation);
        return ResponseEntity.ok(ReservationMapper.toDto(updatedReservation));
    }

    @PatchMapping("/update-status/{reservationId}")
    public ResponseEntity<ReservationDTO> updateReservationStatus(@PathVariable UUID reservationId,
                                                                  @RequestBody UpdateReservationStatusRequestBody requestBody) {
        Reservation updatedReservation = reservationService.updateReservationStatus(reservationId, requestBody.status());
        return ResponseEntity.ok(ReservationMapper.toDto(updatedReservation));
    }


    @DeleteMapping("/delete/{reservationId}")
    public ResponseEntity<ReservationDTO> deleteReservation(@PathVariable UUID reservationId) {
        Reservation deletedReservation = reservationService.deleteReservation(reservationId);
        return ResponseEntity.ok(ReservationMapper.toDto(deletedReservation));
    }
}
