package com.dauphinesitn.reservation_service.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "location-service")
public interface CustomerClient {
}
