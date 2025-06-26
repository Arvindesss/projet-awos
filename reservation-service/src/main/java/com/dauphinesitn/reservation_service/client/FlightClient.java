package com.dauphinesitn.reservation_service.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "flight-service")
public interface FlightClient {
}
