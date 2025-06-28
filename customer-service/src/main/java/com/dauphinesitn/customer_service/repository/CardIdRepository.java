package com.dauphinesitn.customer_service.repository;

import com.dauphinesitn.customer_service.model.CardId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CardIdRepository extends JpaRepository<CardId, UUID> {
}
