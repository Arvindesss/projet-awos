package com.dauphinesitn.payment_service.service.impl;

import com.dauphinesitn.payment_service.dto.PaymentDTO;
import com.dauphinesitn.payment_service.model.Payment;
import com.dauphinesitn.payment_service.repository.PaymentRepository;
import com.dauphinesitn.payment_service.service.PaymentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private PaymentRepository paymentRepository;

    @Override
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    @Override
    public List<Payment> getAllPaymentsByYear(int year) {
        return paymentRepository.findByYear(year);
    }

    @Override
    public Payment getPaymentById(UUID id) {
        return paymentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment not found with id: " + id));
    }

    @Override
    public Payment createPayment(PaymentDTO payment) {
        Payment newPayment = Payment.builder()
                .paymentId(UUID.randomUUID())
                .customerId(payment.customerId())
                .amount(payment.amount())
                .build();
        return paymentRepository.save(newPayment);
    }
}
