package com.dauphinesitn.reservation_service.service.impl;

import com.dauphinesitn.reservation_service.client.CustomerClient;
import com.dauphinesitn.reservation_service.client.FlightClient;
import com.dauphinesitn.reservation_service.client.InventoryClient;
import com.dauphinesitn.reservation_service.client.PricingClient;
import com.dauphinesitn.reservation_service.dto.*;
import com.dauphinesitn.reservation_service.model.Reservation;
import com.dauphinesitn.reservation_service.repository.ReservationRepository;
import com.dauphinesitn.reservation_service.service.ReservationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;

    private final FlightClient flightClient;

    private final CustomerClient customerClient;

    private final PricingClient pricingClient;

    private final InventoryClient inventoryClient;

    @Override
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation getReservationById(UUID reservationId) {
        return reservationRepository.findById(reservationId)
                .orElseThrow(() -> new IllegalArgumentException("Reservation not found for ID: " + reservationId));
    }

    @Override
    public Reservation createReservation(ReservationDTO reservationDTO) {
        // Validate the existence of customer and flight
        CustomerDTO customer = customerClient.getCustomerById(reservationDTO.customerId()).getBody();
        FlightDTO flight = flightClient.getFlightById(reservationDTO.flightId()).getBody();

        // Check if a seat is available for the flight in the inventory
        InventoryAvailabilityDTO inventory = inventoryClient.getInventoryByFlightId(reservationDTO.flightId()).getBody();
        inventory.seatInventory().stream().filter(seat -> seat.seatNumber().equals(reservationDTO.seatNumber())
                && seat.isAvailable()).findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Seat not available: " + reservationDTO.seatNumber()));

        // Update the seat inventory to mark the seat as reserved
        SeatInventoryDTO seatInventoryDTO = SeatInventoryDTO.builder()
                .seatNumber(reservationDTO.seatNumber())
                .isAvailable(false)
                .build();
        inventoryClient.updateSeatAvailability(inventory.flightId(), seatInventoryDTO);

        // Calculate the price of the reservation using the pricing service
        ItineraryPricingDTO itineraryPricing = pricingClient.getItineraryPricingByAirportIds(
                ItineraryPricingDTO.builder()
                        .departureAirportId(flight.flightItineraryDTO().departureAirportId())
                        .arrivalAirportId(flight.flightItineraryDTO().arrivalAirportId())
                        .build()).getBody();

        Reservation newReservation = Reservation.builder()
                .reservationId(UUID.randomUUID())
                .customerId(reservationDTO.customerId())
                .flightId(reservationDTO.flightId())
                .price(itineraryPricing.price())
                .reservedSeatNumber(reservationDTO.seatNumber())
                .status(Reservation.Status.PENDING)
                .build();
        return reservationRepository.save(newReservation);
    }

    @Override
    public Reservation updateReservation(UUID reservationId, ReservationDTO reservationDTO) {
        Reservation existingReservation = reservationRepository.findById(reservationId)
                .orElseThrow(() -> new IllegalArgumentException("Reservation not found for ID: " + reservationId));
        existingReservation.setCustomerId(reservationDTO.customerId());
        existingReservation.setFlightId(reservationDTO.flightId());
        existingReservation.setPrice(reservationDTO.price());
        existingReservation.setCurrency(reservationDTO.currency());
        existingReservation.setReservedSeatNumber(reservationDTO.seatNumber());
        existingReservation.setStatus(Reservation.Status.valueOf(reservationDTO.status().name()));
        return reservationRepository.save(existingReservation);
    }

    @Override
    public Reservation updateReservationStatus(UUID reservationId, ReservationDTO.Status status) {
        Reservation existingReservation = reservationRepository.findById(reservationId)
                .orElseThrow(() -> new IllegalArgumentException("Reservation not found for ID: " + reservationId));
        existingReservation.setStatus(Reservation.Status.valueOf(status.name()));
        return reservationRepository.save(existingReservation);
    }

    @Override
    public Reservation deleteReservation(UUID reservationId) {
        Reservation reservation = reservationRepository.findById(reservationId)
                .orElseThrow(() -> new IllegalArgumentException("Reservation not found for ID: " + reservationId));
        reservationRepository.delete(reservation);
        return reservation;
    }
}
