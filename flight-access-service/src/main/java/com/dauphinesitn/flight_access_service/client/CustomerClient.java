package com.dauphinesitn.flight_access_service.client;

import com.dauphinesitn.flight_access_service.dto.CustomerDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient(name = "customer-service")
public interface CustomerClient {

    @GetMapping("/v1/customers/{customerId}")
    CustomerDTO getCustomerById(@PathVariable UUID customerId);

    @GetMapping("/v1/customers/card/{cardId}")
    CustomerDTO getCustomerByCardId(@PathVariable UUID cardId);
}
