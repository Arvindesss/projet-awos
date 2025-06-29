package com.dauphinesitn.inventory_service.repository;

import com.dauphinesitn.inventory_service.model.SeatInventory;
import com.dauphinesitn.inventory_service.model.SeatInventoryId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatInventoryRepository extends JpaRepository<SeatInventory, SeatInventoryId> {
}
