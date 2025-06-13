package com.dauphinesitn.location_service.mapper;

import com.dauphinesitn.location_service.dto.CityDTO;
import com.dauphinesitn.location_service.model.City;

import java.util.List;

public class CityMapper {


    public static CityDTO toDTO(City city) {
        return CityDTO.builder()
                .uuid(city.getUuid())
                .name(city.getName())
                .country(CountryMapper.toDTO(city.getCountry()))
                .build();
    }

    public static List<CityDTO> toDTO(List<City> cities) {
        return cities.stream()
                .map(CityMapper::toDTO)
                .toList();
    }
}
