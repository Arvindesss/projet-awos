package com.dauphinesitn.payment_service;

import com.dauphinesitn.payment_service.model.Payment;
import com.dauphinesitn.payment_service.repository.PaymentRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class DataInitializer {

    private final PaymentRepository paymentRepository;

    @PostConstruct
    public void init() {
        Payment p1 = Payment.builder()
                .paymentId(UUID.randomUUID())
                .customerId(UUID.fromString("11111111-1111-1111-1111-111111111111"))
                .description("Paiement réservation vol ABC123")
                .amount(120.0)
                .currency("EUR")
                .paymentDate(LocalDateTime.now())
                .build();

        Payment p2 = Payment.builder()
                .paymentId(UUID.randomUUID())
                .customerId(UUID.fromString("22222222-2222-2222-2222-222222222222"))
                .description("Paiement réservation vol XYZ789")
                .amount(250.0)
                .currency("EUR")
                .paymentDate(LocalDateTime.now())
                .build();

        paymentRepository.save(p1);
        paymentRepository.save(p2);
    }
}
