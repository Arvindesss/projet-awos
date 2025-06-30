package com.dauphinesitn.flight_service;

import com.dauphinesitn.flight_service.model.*;
import com.dauphinesitn.flight_service.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Component
public class FlightDataInitializer {

    private final PlaneRepository planeRepository;

    private final SeatRepository seatRepository;

    private final FlightItineraryRepository flightItineraryRepository;

    private final FlightRepository flightRepository;

    @Autowired
    public FlightDataInitializer(PlaneRepository planeRepository,
                                 SeatRepository seatRepository,
                                 FlightItineraryRepository flightItineraryRepository,
                                 FlightRepository flightRepository) {
        this.planeRepository = planeRepository;
        this.seatRepository = seatRepository;
        this.flightItineraryRepository = flightItineraryRepository;
        this.flightRepository = flightRepository;
    }

    @PostConstruct
    public void init() {
        // 1. Création d’un avion
        UUID planeId = UUID.fromString("11111111-1111-1111-1111-111111111111");
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
                .flatMap(row -> Stream.of("A", "B", "C", "D", "E", "F")
                        .map(letter -> {
                            String seatNumber = row + letter;
                            SeatId seatId = new SeatId(planeId, seatNumber);
                            return Seat.builder()
                                    .seatId(seatId)
                                    .description("Seat " + seatNumber)
                                    .plane(plane)
                                    .build();
                        }))
                .collect(Collectors.toList());

        seatRepository.saveAll(seats);

        // 3. Création d’un itinéraire de vol
        UUID departureAirportId = UUID.fromString("11111111-1111-1111-1111-111111111111");
        UUID arrivalAirportId = UUID.fromString("22222222-2222-2222-2222-222222222222");

        FlightItineraryId itineraryId = new FlightItineraryId(departureAirportId, arrivalAirportId);
        FlightItinerary itinerary = new FlightItinerary(itineraryId);
        flightItineraryRepository.save(itinerary);

        // 4. Création d’un vol
        Flight flight = Flight.builder()
                .flightId(UUID.fromString("11111111-1111-1111-1111-111111111111"))
                .plane(plane)
                .flightItinerary(itinerary)
                .departureTime(LocalDateTime.now().plusDays(2).withHour(9).withMinute(0))
                .arrivalTime(LocalDateTime.now().plusDays(2).withHour(11).withMinute(0))
                .build();

        Flight flight2 = Flight.builder()
                .flightId(UUID.fromString("22222222-2222-2222-2222-222222222222"))
                .plane(plane)
                .flightItinerary(itinerary)
                .departureTime(LocalDateTime.now().plusDays(9).withHour(9).withMinute(0))
                .arrivalTime(LocalDateTime.now().plusDays(9).withHour(11).withMinute(0))
                .build();
        flightRepository.save(flight);
        flightRepository.save(flight2);
    }
}
