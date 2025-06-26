package com.dauphinesitn.reservation_service.service;

import com.dauphinesitn.reservation_service.dto.InventoryDTO;
import com.dauphinesitn.reservation_service.dto.ReservedLuggageDTO;
import com.dauphinesitn.reservation_service.dto.SeatInventoryDTO;
import com.dauphinesitn.reservation_service.model.Inventory;

import java.util.List;
import java.util.UUID;

public interface InventoryService {

    List<Inventory> getAllInventory();

    Inventory getInventoryByFlightId(UUID flightId);

    Inventory updateSeatAvailability(UUID flightId, SeatInventoryDTO inventory);

    Inventory addLuggages(UUID flightId, List<ReservedLuggageDTO> luggages);

    Inventory createInventory(InventoryDTO inventory);

    Inventory deleteInventory(UUID flightId);
}
