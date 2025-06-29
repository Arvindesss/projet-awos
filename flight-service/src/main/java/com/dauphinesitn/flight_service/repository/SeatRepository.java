package com.dauphinesitn.flight_service.repository;

import com.dauphinesitn.flight_service.model.Seat;
import com.dauphinesitn.flight_service.model.SeatId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepository extends JpaRepository<Seat, SeatId> {
}
