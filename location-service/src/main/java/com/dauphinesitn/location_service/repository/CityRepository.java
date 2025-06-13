package com.dauphinesitn.location_service.repository;

import com.dauphinesitn.location_service.dto.CityDTO;
import com.dauphinesitn.location_service.model.City;
import com.dauphinesitn.location_service.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CityRepository extends JpaRepository<City, UUID> {

    List<City> findByName(String name);

    List<City> findByCountry(Country country);
}
