package com.dauphinesitn.flight_service.repository;

import com.dauphinesitn.flight_service.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FlightRepository extends JpaRepository<Flight, UUID> {
}
