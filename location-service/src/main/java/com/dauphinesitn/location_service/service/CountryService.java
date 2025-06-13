package com.dauphinesitn.location_service.service;

import com.dauphinesitn.location_service.dto.CountryDTO;
import com.dauphinesitn.location_service.model.Country;

import java.util.List;
import java.util.UUID;

public interface CountryService {

    List<Country> getAllCountries();

    Country getCountryById(UUID id);

    Country getCountryByName(String countryName);

    Country createCountry(CountryDTO countryDTO);

    Country deleteCountry(UUID id);
}
