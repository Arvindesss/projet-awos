package com.dauphinesitn.inventory_service;

import com.dauphinesitn.inventory_service.model.*;
import com.dauphinesitn.inventory_service.repository.InventoryRepository;
import com.dauphinesitn.inventory_service.repository.SeatInventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
@RequiredArgsConstructor
public class InventoryDataInitializer {

    private final InventoryRepository inventoryRepository;
    private final SeatInventoryRepository seatInventoryRepository;

    @PostConstruct
    public void init() {
        // UUID du vol existant (doit correspondre à celui défini dans FlightDataInitializer)
        UUID flightId = UUID.fromString("11111111-1111-1111-1111-111111111111");

        // Création de l’Inventory
        Inventory inventory = Inventory.builder()
                .flightId(flightId)
                .build();


        // Création des SeatInventory
        List<SeatInventory> seatInventories = IntStream.rangeClosed(1, 30)
                .boxed()
                .flatMap(row -> List.of("A", "B", "C", "D", "E", "F").stream()
                        .map(letter -> SeatInventory.builder()
                                .seatInventoryId(new SeatInventoryId(flightId, row + letter))
                                .isAvailable(true)
                                .inventory(inventory)
                                .build()))
                .collect(Collectors.toList());

        inventory.setSeatInventory(seatInventories);

        inventoryRepository.save(inventory);
        seatInventoryRepository.saveAll(seatInventories);


        UUID flightId2 = UUID.fromString("22222222-2222-2222-2222-222222222222");

        // Création de l’Inventory
        Inventory inventory2 = Inventory.builder()
                .flightId(flightId2)
                .build();

        // Création des SeatInventory
        List<SeatInventory> seatInventories2 = IntStream.rangeClosed(1, 30)
                .boxed()
                .flatMap(row -> List.of("A", "B", "C", "D", "E", "F").stream()
                        .map(letter -> SeatInventory.builder()
                                .seatInventoryId(new SeatInventoryId(flightId2, row + letter))
                                .isAvailable(true)
                                .inventory(inventory2)
                                .build()))
                .collect(Collectors.toList());

        inventory2.setSeatInventory(seatInventories2);

        inventoryRepository.save(inventory2);
        seatInventoryRepository.saveAll(seatInventories2);

    }
}
