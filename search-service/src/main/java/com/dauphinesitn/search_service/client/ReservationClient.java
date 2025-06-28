package com.dauphinesitn.search_service.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "reservation-service")
public interface ReservationClient {
}
