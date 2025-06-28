package com.dauphinesitn.flight_access_service.repository;

import com.dauphinesitn.flight_access_service.model.CheckIn;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CheckInRepository extends JpaRepository<CheckIn, UUID> {

    Optional<CheckIn> findByReservationId(UUID reservationId);
}
