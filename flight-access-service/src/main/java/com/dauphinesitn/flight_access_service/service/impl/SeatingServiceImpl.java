package com.dauphinesitn.flight_access_service.service.impl;

import com.dauphinesitn.flight_access_service.client.ReservationClient;
import com.dauphinesitn.flight_access_service.dto.InventoryDTO;
import com.dauphinesitn.flight_access_service.dto.SeatInventoryDTO;
import com.dauphinesitn.flight_access_service.dto.SeatingDTO;
import com.dauphinesitn.flight_access_service.service.SeatingService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class SeatingServiceImpl implements SeatingService {

    private ReservationClient inventoryClient;

    @Override
    public InventoryDTO assignSeat(SeatingDTO seatingDTO) {
        InventoryDTO inventory = inventoryClient.getInventoryByFlightId(seatingDTO.flightId()).getBody();
        UUID seatId = inventory.seatInventory().stream().filter(SeatInventoryDTO::isAvailable).findFirst().orElseThrow(() -> new RuntimeException("No available seats found")).seatId();
        SeatInventoryDTO seatInventoryDTO = SeatInventoryDTO.builder()
                .seatId(seatId)
                .flightId(seatingDTO.flightId())
                .isAvailable(false)
                .build();
       return inventoryClient.updateSeatAvailability(seatInventoryDTO).getBody();
    }

    @Override
    public InventoryDTO deassignSeat(SeatingDTO seatingDTO) {
        InventoryDTO inventory = inventoryClient.getInventoryByFlightId(seatingDTO.flightId()).getBody();
        UUID seatId = inventory.seatInventory().stream().filter(SeatInventoryDTO::isAvailable).findFirst().orElseThrow(() -> new RuntimeException("No available seats found")).seatId();
        SeatInventoryDTO seatInventoryDTO = SeatInventoryDTO.builder()
                .seatId(seatId)
                .flightId(seatingDTO.flightId())
                .isAvailable(true)
                .build();
        return inventoryClient.updateSeatAvailability(seatInventoryDTO).getBody();
    }
}
