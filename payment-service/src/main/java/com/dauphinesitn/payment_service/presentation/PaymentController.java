package com.dauphinesitn.payment_service.presentation;

import com.dauphinesitn.payment_service.mapper.PaymentMapper;
import com.dauphinesitn.payment_service.dto.PaymentDTO;
import com.dauphinesitn.payment_service.model.Payment;
import com.dauphinesitn.payment_service.service.PaymentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/payments")
@AllArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;


    @GetMapping("/{id}")
    public ResponseEntity<PaymentDTO> getPaymentById(UUID id) {
        Payment payment = paymentService.getPaymentById(id);
        return ResponseEntity.ok(PaymentMapper.toDto(payment));
    }

    @PostMapping("/pay-reservation/{reservationId}")
    public ResponseEntity<PaymentDTO> payReservation(@PathVariable UUID reservationId, @RequestBody PaymentDTO paymentDTO) {
        Payment payment = paymentService.payReservation(paymentDTO, reservationId);
        return ResponseEntity.ok(PaymentMapper.toDto(payment));
    }

    @GetMapping("")
    public ResponseEntity<List<PaymentDTO>> getAllPayments() {
        List<Payment> payments = paymentService.getAllPayments();
        return ResponseEntity.ok(PaymentMapper.toDto(payments));
    }

}
