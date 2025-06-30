package com.dauphinesitn.flight_access_service.service.impl;

import com.dauphinesitn.flight_access_service.client.InventoryClient;
import com.dauphinesitn.flight_access_service.dto.InventoryDTO;
import com.dauphinesitn.flight_access_service.dto.SeatInventoryDTO;
import com.dauphinesitn.flight_access_service.dto.SeatingDTO;
import com.dauphinesitn.flight_access_service.service.SeatingService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SeatingServiceImpl implements SeatingService {

    private InventoryClient inventoryClient;

    @Override
    public String assignSeat(SeatingDTO seatingDTO) {
        InventoryDTO inventory = inventoryClient.getInventoryByFlightId(seatingDTO.flightId()).getBody();
        String seatNumber = inventory.seatInventory().stream().filter(SeatInventoryDTO::isAvailable).findFirst().orElseThrow(() -> new RuntimeException("No available seats found")).seatNumber();
        SeatInventoryDTO seatInventoryDTO = SeatInventoryDTO.builder()
                .seatNumber(seatNumber)
                .flightId(seatingDTO.flightId())
                .isAvailable(false)
                .build();
       inventoryClient.updateSeatAvailability(seatInventoryDTO).getBody();
       return seatNumber;
    }
}
