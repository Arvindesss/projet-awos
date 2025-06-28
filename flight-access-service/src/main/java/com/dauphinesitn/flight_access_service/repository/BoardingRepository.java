package com.dauphinesitn.flight_access_service.repository;

import com.dauphinesitn.flight_access_service.model.Boarding;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BoardingRepository extends JpaRepository<Boarding, UUID> {
}
