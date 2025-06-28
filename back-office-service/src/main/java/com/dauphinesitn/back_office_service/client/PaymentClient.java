package com.dauphinesitn.back_office_service.client;

import com.dauphinesitn.back_office_service.dto.PaymentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "payment-service")
public interface PaymentClient {

    @GetMapping("/api/payments")
    ResponseEntity<List<PaymentDTO>> getAllPayments(@RequestParam(required = false) int year); // This method should return a list of payments in JSON format or a DTO, adjust as necessary.
}
