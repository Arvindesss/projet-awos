package com.dauphinesitn.flight_access_service.service;

import com.dauphinesitn.flight_access_service.dto.InventoryDTO;
import com.dauphinesitn.flight_access_service.dto.SeatingDTO;

public interface SeatingService {

    InventoryDTO assignSeat(SeatingDTO seatingDTO);

    InventoryDTO deassignSeat(SeatingDTO seatingDTO);
}
