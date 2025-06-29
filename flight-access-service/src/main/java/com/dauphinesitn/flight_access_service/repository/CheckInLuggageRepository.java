package com.dauphinesitn.flight_access_service.repository;

import com.dauphinesitn.flight_access_service.model.CheckInLuggage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CheckInLuggageRepository extends JpaRepository<CheckInLuggage, UUID> {
}
