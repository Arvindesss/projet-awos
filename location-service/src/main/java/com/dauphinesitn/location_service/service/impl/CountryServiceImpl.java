package com.dauphinesitn.location_service.service.impl;

import com.dauphinesitn.location_service.dto.CountryDTO;
import com.dauphinesitn.location_service.model.Country;
import com.dauphinesitn.location_service.repository.CountryRepository;
import com.dauphinesitn.location_service.service.CountryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    @Override
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    @Override
    public Country getCountryById(UUID id) {
        return countryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Country not found with id: " + id));
    }

    @Override
    public Country getCountryByName(String countryName) {
        return countryRepository.findByNameIgnoreCase(countryName)
                .orElseThrow(() -> new IllegalArgumentException("Country not found with name: " + countryName));
    }

    @Override
    public Country createCountry(CountryDTO countryDTO) {
        Country country = Country.builder()
                .uuid(UUID.randomUUID())
                .name(countryDTO.name())
                .currency(countryDTO.currency())
                .build();
        return countryRepository.save(country);
    }

    @Override
    public Country deleteCountry(UUID id) {
        Country country = countryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Country not found with id: " + id));
      countryRepository.deleteById(id);
      return country;
    }
}
