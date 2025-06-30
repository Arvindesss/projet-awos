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

import java.time.LocalDateTime;
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
    public List<Payment> getAllPaymentsByYear(int year) {
        return paymentRepository.findByYear(year);
    }

    @Override
    public Payment getPaymentById(UUID id) {
        return paymentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment not found with id: " + id));
    }

    @Override
    public Payment payReservation(UUID reservationId, PaymentDTO paymentDTO) {
        //Check if reservation exists
       ReservationDTO reservationDTO = reservationClient.getReservationById(reservationId).getBody();
       validatePayment(paymentDTO, reservationDTO);
        //Create payment
        Payment newPayment = Payment.builder()
                .paymentId(UUID.randomUUID())
                .customerId(paymentDTO.customerId())
                .description("Payment for reservation " + reservationId)
                .amount(paymentDTO.amount())
                .currency(paymentDTO.currency())
                .paymentDate(LocalDateTime.now())
                .build();

        reservationClient.updateReservationStatus(UpdateReservationStatusRequestBody.builder()
                .reservationId(reservationId)
                .status(ReservationDTO.Status.CONFIRMED)
                .build());

        return paymentRepository.save(newPayment);
    }

    private static void validatePayment(PaymentDTO paymentDTO, ReservationDTO reservationDTO) {
        //Check if customerId matches
        if (!reservationDTO.customerId().equals(paymentDTO.customerId())) {
            throw new RuntimeException("Customer ID does not match the reservation's customer ID.");
        }

        //Check if reservation is in a valid state for payment
        if( reservationDTO.status() != ReservationDTO.Status.PENDING) {
            throw new RuntimeException("Reservation is not in a valid state for payment.");
        }

        //Check if payment amount matches reservation price
        if(reservationDTO.price() !=  paymentDTO.amount()) {
            throw new RuntimeException("Payment price is invalid.");
        }
    }
}
