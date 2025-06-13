package com.dauphinesitn.location_service.repository;

import com.dauphinesitn.location_service.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CountryRepository extends JpaRepository<Country, UUID> {

    Optional<Country> findByNameIgnoreCase(String countryName);

}
