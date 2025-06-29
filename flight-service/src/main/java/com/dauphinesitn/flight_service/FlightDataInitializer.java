package com.dauphinesitn.flight_service.config;

import com.dauphinesitn.flight_service.model.*;
import com.dauphinesitn.flight_service.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
@RequiredArgsConstructor
public class FlightDataInitializer {

    private final PlaneRepository planeRepository;
    private final SeatRepository seatRepository;
    private final FlightItineraryRepository flightItineraryRepository;
    private final FlightRepository flightRepository;

    @PostConstruct
    public void init() {
        // 1. Création d’un avion
        UUID planeId = UUID.randomUUID();
        Plane plane = Plane.builder()
                .planeId(planeId)
                .model("A320")
                .manufacturer("Airbus")
                .maxCapacity(180)
                .maxBaggageWeight(2000)
                .build();
        planeRepository.save(plane);

        // 2. Génération automatique des sièges
        List<Seat> seats = IntStream.rangeClosed(1, 30)
                .boxed()
                .flatMap(row -> List.of("A", "B", "C", "D", "E", "F").stream()
                        .map(letter -> new Seat(
                                new SeatId(planeId, row + letter),
                                "Seat " + row + letter,
                                plane)))
                .collect(Collectors.toList());
        seatRepository.saveAll(seats);

        // 3. Création d’un itinéraire de vol
        // Assure-toi que les 2 aéroports existent en DB, ou remplace leurs UUIDs
        UUID departureAirportId = UUID.fromString("00000000-0000-0000-0000-000000000001"); // CDG ?
        UUID arrivalAirportId = UUID.fromString("00000000-0000-0000-0000-000000000002");   // LHR ?

        FlightItineraryId itineraryId = new FlightItineraryId(departureAirportId, arrivalAirportId);
        FlightItinerary itinerary = new FlightItinerary(itineraryId);
        flightItineraryRepository.save(itinerary);

        // 4. Création d’un vol
        Flight flight = Flight.builder()
                .flightId(UUID.randomUUID())
                .plane(plane)
                .flightItinerary(itinerary)
                .departureTime(LocalDateTime.now().plusDays(2).withHour(9).withMinute(0))
                .arrivalTime(LocalDateTime.now().plusDays(2).withHour(11).withMinute(0))
                .build();
        flightRepository.save(flight);
    }
}
