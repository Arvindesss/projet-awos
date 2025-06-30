package com.dauphinesitn.location_service.service.impl;

import com.dauphinesitn.location_service.dto.AirportDTO;
import com.dauphinesitn.location_service.model.Airport;
import com.dauphinesitn.location_service.model.City;
import com.dauphinesitn.location_service.model.Country;
import com.dauphinesitn.location_service.repository.AirportRepository;
import com.dauphinesitn.location_service.repository.CityRepository;
import com.dauphinesitn.location_service.repository.CountryRepository;
import com.dauphinesitn.location_service.service.AirportService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AirportServiceImpl implements AirportService {

    private final AirportRepository airportRepository;

    private final CountryRepository countryRepository;

    private final CityRepository cityRepository;

    @Override
    public List<Airport> getAllAirports() {
        return airportRepository.findAll();
    }

    @Override
    public Airport getAirportById(UUID id) {
        return airportRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Airport not found with id: " + id));
    }

    @Override
    public Airport getAirportByName(String name) {
        return airportRepository.findByNameIgnoreCase(name)
                .orElseThrow(() -> new IllegalArgumentException("Airport not found with name: " + name));
    }

    @Override
    public Airport createAirport(AirportDTO airport) {
        City city = cityRepository.findById(airport.cityId())
                .orElseThrow(() -> new IllegalArgumentException("City not found with id: " + airport.cityId()));
        Airport newAirport = Airport.builder()
                .airportId(UUID.randomUUID())
                .name(airport.name())
                .city(city)
                .build();
        return airportRepository.save(newAirport);
    }

    @Override
    public Airport updateAirport(UUID id, AirportDTO airport) {
        Airport existingAirport = airportRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Airport not found with id: " + id));
        City city = cityRepository.findById(airport.cityId())
                .orElseThrow(() -> new IllegalArgumentException("City not found with id: " + airport.cityId()));
        existingAirport.setName(airport.name());
        existingAirport.setCity(city);
        return airportRepository.save(existingAirport);
    }

    @Override
    public Airport deleteAirport(UUID id) {
        Airport airport = airportRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Airport not found with id: " + id));
        airportRepository.delete(airport);
        return airport;
    }
}
