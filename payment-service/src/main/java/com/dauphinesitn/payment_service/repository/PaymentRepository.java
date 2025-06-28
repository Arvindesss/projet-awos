package com.dauphinesitn.payment_service.repository;

import com.dauphinesitn.payment_service.model.Payment;
import feign.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface PaymentRepository extends JpaRepository<Payment, UUID> {

    @Query("SELECT p FROM Payment p WHERE YEAR(p.paymentDate) = :year")
    List<Payment> findByYear(@Param("year") int year);
}
