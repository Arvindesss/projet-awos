package com.dauphinesitn.flight_access_service.client;

import com.dauphinesitn.flight_access_service.dto.ReservationDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient(name = "reservation-service")
public interface ReservationClient {

    @GetMapping("/v1/reservations/{reservationId}")
    ReservationDTO getReservationById(@PathVariable UUID reservationId);

}
