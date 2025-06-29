package com.dauphinesitn.inventory_service.service;


import com.dauphinesitn.inventory_service.dto.InventoryDTO;
import com.dauphinesitn.inventory_service.dto.SeatInventoryDTO;
import com.dauphinesitn.inventory_service.model.Inventory;

import java.util.List;
import java.util.UUID;

public interface InventoryService {

    List<Inventory> getAllInventory();

    Inventory getInventoryByFlightId(UUID flightId);

    Inventory updateSeatAvailability(UUID flightId, SeatInventoryDTO inventory);

    Inventory createInventory(InventoryDTO inventory);

    Inventory deleteInventory(UUID flightId);
}
