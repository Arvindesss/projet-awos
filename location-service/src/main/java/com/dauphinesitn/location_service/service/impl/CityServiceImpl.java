package com.dauphinesitn.location_service.service.impl;

import com.dauphinesitn.location_service.dto.CityDTO;
import com.dauphinesitn.location_service.dto.CityDTOResponse;
import com.dauphinesitn.location_service.mapper.CountryMapper;
import com.dauphinesitn.location_service.model.City;
import com.dauphinesitn.location_service.model.Country;
import com.dauphinesitn.location_service.repository.CityRepository;
import com.dauphinesitn.location_service.repository.CountryRepository;
import com.dauphinesitn.location_service.service.CityService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;

    private final CountryRepository countryRepository;

    @Override
    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    @Override
    public City getCityById(UUID id) {
        return cityRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("City not found with id: " + id));
    }

    @Override
    public List<City> getCityByName(String name) {
        return cityRepository.findByName(name);
    }

    @Override
    public List<City> getAllCitiesByCountryId(UUID countryId) {
        Country country = countryRepository.findById(countryId)
            .orElseThrow(() -> new IllegalArgumentException("Country not found with id: " + countryId));
        return cityRepository.findByCountry(country);
    }

    @Override
    public List<City> getAllCitiesByCountryName(String countryName) {
        Country country = countryRepository.findByNameIgnoreCase(countryName)
                .orElseThrow(() -> new IllegalArgumentException("Country not found with name: " + countryName));
        return cityRepository.findByCountry(country);
    }

    @Override
    public City createCity(CityDTO cityDTO) {
        Country country = countryRepository.findById(cityDTO.countryId())
                .orElseThrow(() -> new IllegalArgumentException("Country not found with id: " + cityDTO.countryId()));
        City city = City.builder()
                .uuid(UUID.randomUUID())
                .name(cityDTO.name())
                .postalCode(cityDTO.postalCode())
                .country(country)
                .build();
        return cityRepository.save(city);
    }

    @Override
    public City deleteCity(UUID uuid) {
        City city = cityRepository.findById(uuid)
                .orElseThrow(() -> new IllegalArgumentException("City not found with id: " + uuid));
        cityRepository.delete(city);
        return city;
    }
}
