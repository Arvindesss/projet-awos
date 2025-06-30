package com.dauphinesitn.payment_service.mapper;

import com.dauphinesitn.payment_service.dto.PaymentDTO;
import com.dauphinesitn.payment_service.model.Payment;

import java.util.List;

public class PaymentMapper {

    public static PaymentDTO toDto(Payment payment) {
        return PaymentDTO.builder()
                .paymentId(payment.getPaymentId())
                .customerId(payment.getCustomerId())
                .description(payment.getDescription())
                .amount(payment.getAmount())
                .currency(payment.getCurrency())
                .paymentDate(payment.getPaymentDate())
                .build();
    }

    public static List<PaymentDTO> toDto(List<Payment> payment) {
       return payment.stream()
                .map(PaymentMapper::toDto)
                .toList();
    }
}
