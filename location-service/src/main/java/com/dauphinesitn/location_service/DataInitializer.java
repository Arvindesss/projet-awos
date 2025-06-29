package com.dauphinesitn.location_service;

import com.dauphinesitn.location_service.model.Airport;
import com.dauphinesitn.location_service.model.City;
import com.dauphinesitn.location_service.model.Country;
import com.dauphinesitn.location_service.repository.AirportRepository;
import com.dauphinesitn.location_service.repository.CityRepository;
import com.dauphinesitn.location_service.repository.CountryRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class DataInitializer {

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private CityRepository cityRepository;

    @Autowired private AirportRepository airportRepository;

    @PostConstruct
    public void init() {
        // Pays
        Country france = countryRepository.save(Country.builder()
                .uuid(UUID.randomUUID())
                .name("France")
                .currency("EUR")
                .build());

        // Ville
        City paris = cityRepository.save(City.builder()
                .uuid(UUID.randomUUID())
                .name("Paris")
                .postalCode("75000")
                .country(france)
                .build());

        // Aéroport
        Airport cdg = Airport.builder()
                .airportId(UUID.randomUUID())
                .name("Charles de Gaulle")
                .city(paris)
                .country(france) // facultatif si redondant
                .build();

        airportRepository.save(cdg);
    }
}
