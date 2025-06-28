package com.dauphinesitn.payment_service.client;

import com.dauphinesitn.payment_service.dto.ReservationDTO;
import com.dauphinesitn.payment_service.dto.queryparam.UpdateReservationStatusRequestBody;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;

@FeignClient(name = "reservation-service")
public interface ReservationClient {

    @GetMapping("/v1/reservations/{reservationId}")
    ResponseEntity<ReservationDTO> getReservationById(@PathVariable UUID reservationId);

    @PatchMapping("/v1/reservations/update-status/{reservationId}")
    ResponseEntity<ReservationDTO> updateReservationStatus(@PathVariable UUID reservationId,
                                                           @RequestBody UpdateReservationStatusRequestBody requestBody);
}
