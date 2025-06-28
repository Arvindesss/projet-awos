package com.dauphinesitn.payment_service.presentation;

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
@RequestMapping("/api/payments")
@AllArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @GetMapping("")
    public ResponseEntity<List<PaymentDTO>> getAllPayments(@RequestParam(required = false) int year) {

        List<Payment> payments = year <= 0
                ? paymentService.getAllPayments()
                : paymentService.getAllPaymentsByYear(year);
        return ResponseEntity.ok(PaymentMapper.toDto(payments));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaymentDTO> getPaymentById(UUID id ) {
        Payment payment = paymentService.getPaymentById(id);
        return ResponseEntity.ok(PaymentMapper.toDto(payment));
    }

    @PostMapping("/create")
    public ResponseEntity<PaymentDTO> createPayment(PaymentDTO paymentDTO) {
        Payment payment = paymentService.createPayment(paymentDTO);
        return ResponseEntity.ok(PaymentMapper.toDto(payment));
    }
}
