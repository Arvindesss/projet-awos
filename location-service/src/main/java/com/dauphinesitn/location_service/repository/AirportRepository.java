package com.dauphinesitn.location_service.repository;

import com.dauphinesitn.location_service.model.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface AirportRepository extends JpaRepository<Airport, UUID> {

    Optional<Airport> findByNameIgnoreCase(String name);
}
