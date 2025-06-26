package com.dauphinesitn.reservation_service.repository;

import com.dauphinesitn.reservation_service.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ReservationRepository extends JpaRepository<Reservation, UUID> {

}
