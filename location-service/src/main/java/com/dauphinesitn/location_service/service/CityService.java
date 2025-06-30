package com.dauphinesitn.location_service.service;

import com.dauphinesitn.location_service.dto.CityDTO;
import com.dauphinesitn.location_service.dto.CityDTOResponse;
import com.dauphinesitn.location_service.model.City;

import java.util.List;
import java.util.UUID;

public interface CityService {

    List<City> getAllCities();

    City getCityById(UUID id);

    List<City> getCityByName(String name);

    List<City> getAllCitiesByCountryId(UUID countryId);

    List<City> getAllCitiesByCountryName(String countryName);

    City createCity(CityDTO cityDTO);

    City deleteCity(UUID uuid);
}
