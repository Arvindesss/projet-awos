package com.dauphinesitn.location_service.dto.converter;

import com.dauphinesitn.location_service.dto.CountryDTO;
import com.dauphinesitn.location_service.model.Country;

import java.util.List;

public class CountryToCountryDTOConverter {

    public static CountryDTO convert(Country country) {
        return CountryDTO.builder()
                .uuid(country.getUuid())
                .name(country.getName())
                .currency(country.getCurrency())
                .build();
    }

    public static List<CountryDTO> convert(List<Country> countries) {
        return countries.stream()
                .map(CountryToCountryDTOConverter::convert)
                .toList();
    }
}
