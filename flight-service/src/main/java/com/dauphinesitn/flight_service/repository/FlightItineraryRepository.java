package com.dauphinesitn.flight_service.repository;

import com.dauphinesitn.flight_service.model.FlightItinerary;
import com.dauphinesitn.flight_service.model.FlightItineraryId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightItineraryRepository extends JpaRepository<FlightItinerary, FlightItineraryId> {
}
