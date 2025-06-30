package com.dauphinesitn.payment_service.client;

import com.dauphinesitn.payment_service.dto.ReservationDTO;
import com.dauphinesitn.payment_service.dto.queryparam.UpdateReservationStatusRequestBody;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@FeignClient(name = "reservation-service")
public interface ReservationClient {

    @GetMapping("/v1/reservations/{reservationId}")
    ResponseEntity<ReservationDTO> getReservationById(@PathVariable UUID reservationId);

    @PutMapping("/v1/reservations/update-status")
    ResponseEntity<ReservationDTO> updateReservationStatus(@RequestBody UpdateReservationStatusRequestBody requestBody);
}
