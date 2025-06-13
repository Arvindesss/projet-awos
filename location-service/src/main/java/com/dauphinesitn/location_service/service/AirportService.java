package com.dauphinesitn.location_service.service;

import com.dauphinesitn.location_service.dto.AirportDTO;
import com.dauphinesitn.location_service.model.Airport;

import java.util.UUID;

public interface    AirportService {

    Airport getAirportById(UUID id);

    Airport getAirportByName(String name);

    Airport createAirport(AirportDTO airport);

    Airport updateAirport(UUID id, AirportDTO airport);

    Airport deleteAirport(UUID id);
}
