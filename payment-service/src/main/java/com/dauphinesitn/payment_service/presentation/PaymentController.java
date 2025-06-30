package com.dauphinesitn.payment_service.presentation;

import com.dauphinesitn.payment_service.dto.queryparam.PayReservationRequestBody;
import com.dauphinesitn.payment_service.mapper.PaymentMapper;
import com.dauphinesitn.payment_service.dto.PaymentDTO;
import com.dauphinesitn.payment_service.model.Payment;
import com.dauphinesitn.payment_service.service.PaymentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/payments")
@AllArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @GetMapping("")
    public ResponseEntity<List<PaymentDTO>> getAllPayments(@RequestParam(required = false) Integer year) {
        List<Payment> payments = year == null
                ? paymentService.getAllPayments()
                : paymentService.getAllPaymentsByYear(year);
        return ResponseEntity.ok(PaymentMapper.toDto(payments));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaymentDTO> getPaymentById(@PathVariable UUID id ) {
        Payment payment = paymentService.getPaymentById(id);
        return ResponseEntity.ok(PaymentMapper.toDto(payment));
    }

    @PostMapping("/pay-reservation")
    public ResponseEntity<PaymentDTO> payReservation(@RequestBody PayReservationRequestBody payReservationRequestBody) {
        PaymentDTO paymentDTO = PaymentDTO.builder()
                .customerId(payReservationRequestBody.customerId())
                .description(payReservationRequestBody.description())
                .amount(payReservationRequestBody.amount())
                .currency(payReservationRequestBody.currency())
                .build();
        Payment payment = paymentService.payReservation(payReservationRequestBody.reservationId(), paymentDTO);
        return ResponseEntity.ok(PaymentMapper.toDto(payment));
    }
}
