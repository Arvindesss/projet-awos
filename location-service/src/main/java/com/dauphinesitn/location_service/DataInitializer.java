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
                .uuid(UUID.fromString("11111111-1111-1111-1111-111111111111"))
                .name("France")
                .currency("EUR")
                .build());

        // Ville
        City paris = cityRepository.save(City.builder()
                .uuid(UUID.fromString("11111111-1111-1111-1111-111111111111"))
                .name("Paris")
                .postalCode("75000")
                .country(france)
                .build());

        City lyon = cityRepository.save(City.builder()
                .uuid(UUID.fromString("22222222-2222-2222-2222-222222222222"))
                .name("Lyon")
                .postalCode("69000")
                .country(france)
                .build());

        City marseille = cityRepository.save(City.builder()
                .uuid(UUID.fromString("33333333-3333-3333-3333-333333333333"))
                .name("Marseille")
                .postalCode("13000")
                .country(france)
                .build());

        // Aéroport
        Airport cdg = Airport.builder()
                .airportId(UUID.fromString("11111111-1111-1111-1111-111111111111"))
                .name("Charles de Gaulle")
                .city(paris)
                .build();

        // Aéroport 2
        Airport lyonStex = Airport.builder()
                .airportId(UUID.fromString("22222222-2222-2222-2222-222222222222"))
                .name("Lyon Saint-Exupéry")
                .city(lyon)
                .build();

        Airport marseilleMarignane = Airport.builder()
                .airportId(UUID.fromString("33333333-3333-3333-3333-333333333333"))
                .name("Marseille Provence")
                .city(marseille)
                .build();


        airportRepository.save(cdg);
        airportRepository.save(lyonStex);
        airportRepository.save(marseilleMarignane);
    }
}
