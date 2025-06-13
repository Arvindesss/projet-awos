package com.dauphinesitn.location_service.mapper;

import com.dauphinesitn.location_service.dto.CountryDTO;
import com.dauphinesitn.location_service.model.Country;

import java.util.List;

public class CountryMapper {

    public static CountryDTO toDTO(Country country) {
        return CountryDTO.builder()
                .uuid(country.getUuid())
                .name(country.getName())
                .currency(country.getCurrency())
                .build();
    }

    public static List<CountryDTO> toDTO(List<Country> countries) {
        return countries.stream()
                .map(CountryMapper::toDTO)
                .toList();
    }

    public static Country toEntity(CountryDTO countryDTO) {
        return Country.builder()
                .uuid(countryDTO.uuid())
                .name(countryDTO.name())
                .currency(countryDTO.currency())
                .build();
    }
}
