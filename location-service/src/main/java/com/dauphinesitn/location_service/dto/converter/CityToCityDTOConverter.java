package com.dauphinesitn.location_service.dto.converter;

import com.dauphinesitn.location_service.dto.CityDTO;
import com.dauphinesitn.location_service.model.City;

import java.util.List;

public class CityToCityDTOConverter {


    public static CityDTO convert(City city) {
        return CityDTO.builder()
                .uuid(city.getUuid())
                .name(city.getName())
                .country(CountryToCountryDTOConverter.convert(city.getCountry()))
                .build();
    }

    public static List<CityDTO> convert(List<City> cities) {
        return cities.stream()
                .map(CityToCityDTOConverter::convert)
                .toList();
    }
}
