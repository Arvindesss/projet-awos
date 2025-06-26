package com.dauphinesitn.reservation_service.service;

import com.dauphinesitn.reservation_service.dto.InventoryDTO;
import com.dauphinesitn.reservation_service.model.Inventory;

import java.util.List;
import java.util.UUID;

public interface InventoryService {

    List<Inventory> getAllInventory();

    Inventory getInventoryByFlightId(UUID flightId);

    Inventory updateInventory(UUID flightId, InventoryDTO inventory);

    Inventory createInventory(InventoryDTO inventory);

    Inventory deleteInventory(UUID flightId);
}
