package com.dauphinesitn.payment_service.service.impl;

import com.dauphinesitn.payment_service.client.ReservationClient;
import com.dauphinesitn.payment_service.dto.PaymentDTO;
import com.dauphinesitn.payment_service.dto.ReservationDTO;
import com.dauphinesitn.payment_service.dto.queryparam.UpdateReservationStatusRequestBody;
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

    private ReservationClient reservationClient;

    @Override
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    @Override
    public Payment getPaymentById(UUID id) {
        return paymentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment not found with id: " + id));
    }

    @Override
    public Payment payReservation(PaymentDTO paymentDTO, UUID reservationId) {
        //Check if reservation exists
        reservationClient.getReservationById(reservationId).getBody();

        //Create payment
        Payment newPayment = Payment.builder()
                .paymentId(UUID.randomUUID())
                .customerId(paymentDTO.customerId())
                .description("Payment for reservation " + reservationId)
                .amount(paymentDTO.amount())
                .build();

        reservationClient.updateReservationStatus(reservationId, UpdateReservationStatusRequestBody.builder()
                .status(ReservationDTO.Status.CONFIRMED)
                .build());

        return paymentRepository.save(newPayment);
    }
}
