package com.dauphinesitn.reservation_service.client;

import com.dauphinesitn.reservation_service.dto.CustomerDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient(name = "customer-service")
public interface CustomerClient {

    @GetMapping("/v1/customers/{customerId}")
    ResponseEntity<CustomerDTO> getCustomerById(@PathVariable UUID customerId);
}
