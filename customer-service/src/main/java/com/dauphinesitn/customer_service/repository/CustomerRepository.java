package com.dauphinesitn.customer_service.repository;

import com.dauphinesitn.customer_service.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CustomerRepository extends JpaRepository<Customer, UUID> {
}
