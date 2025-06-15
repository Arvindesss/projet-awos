package com.dauphinesitn.flight_service.repository;

import com.dauphinesitn.flight_service.model.Plane;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PlaneRepository extends JpaRepository<Plane, UUID> {
}
