package com.dauphinesitn.reservation_service.repository;

import com.dauphinesitn.reservation_service.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface InventoryRepository extends JpaRepository<Inventory, UUID> {
}
