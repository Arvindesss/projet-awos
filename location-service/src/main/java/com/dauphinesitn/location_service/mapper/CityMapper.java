package com.dauphinesitn.location_service.mapper;

import com.dauphinesitn.location_service.dto.CityDTOResponse;
import com.dauphinesitn.location_service.model.City;

import java.util.List;

public class CityMapper {


    public static CityDTOResponse toDTO(City city) {
        return CityDTOResponse.builder()
                .uuid(city.getUuid())
                .name(city.getName())
                .postalCode(city.getPostalCode())
                .country(CountryMapper.toDTO(city.getCountry()))
                .build();
    }

    public static List<CityDTOResponse> toDTO(List<City> cities) {
        return cities.stream()
                .map(CityMapper::toDTO)
                .toList();
    }
}
