package com.dauphinesitn.payment_service.service;

import com.dauphinesitn.payment_service.dto.PaymentDTO;
import com.dauphinesitn.payment_service.model.Payment;

import java.util.List;
import java.util.UUID;

public interface PaymentService {

    List<Payment> getAllPayments();

    List<Payment> getAllPaymentsByYear(int year);

    Payment getPaymentById(UUID id);

    Payment payReservation(PaymentDTO paymentDTO, UUID reservationId);
}



