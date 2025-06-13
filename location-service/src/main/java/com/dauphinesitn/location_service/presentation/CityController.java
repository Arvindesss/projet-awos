package com.dauphinesitn.location_service.presentation;

import com.dauphinesitn.location_service.dto.CityDTO;
import com.dauphinesitn.location_service.dto.converter.CityToCityDTOConverter;
import com.dauphinesitn.location_service.dto.converter.CountryToCountryDTOConverter;
import com.dauphinesitn.location_service.model.City;
import com.dauphinesitn.location_service.service.CityService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/cities")
@AllArgsConstructor
public class CityController {

    private final CityService cityService;

    @GetMapping("")
    public ResponseEntity<List<CityDTO>> getAllCities() {
        List<City> cities = cityService.getAllCities();
        return ResponseEntity.ok(CityToCityDTOConverter.convert(cities));
    }

    @GetMapping("/{countryId}")
    public ResponseEntity<List<CityDTO>> getCitiesByCountryId(@PathVariable UUID countryId) {
        List<City> cities = cityService.getAllCitiesByCountryId(countryId);
        return ResponseEntity.ok(CityToCityDTOConverter.convert(cities));
    }

    @GetMapping("/{countryName}")
    public ResponseEntity<List<CityDTO>> getCitiesByCountryName(@PathVariable String countryName) {
        List<City> cities = cityService.getAllCitiesByCountryName(countryName);
        return ResponseEntity.ok(CityToCityDTOConverter.convert(cities));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CityDTO> getCityById(@PathVariable UUID id) {
        City city = cityService.getCityById(id);
        return ResponseEntity.ok(CityToCityDTOConverter.convert(city));
    }


    @GetMapping("/{name}")
    public ResponseEntity<List<CityDTO>> getCityByName(String name) {
        List<City> city = cityService.getCityByName(name);
        return ResponseEntity.ok(CityToCityDTOConverter.convert(city));
    }


    @PostMapping("/create")
    public ResponseEntity<CityDTO> createCity(@RequestBody CityDTO cityDTO) {
       City city = cityService.createCity(cityDTO);
        return ResponseEntity.created(URI.create("/v1/cities/" + city.getUuid())).body(CityToCityDTOConverter.convert(city));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<CityDTO> deleteCity(@PathVariable UUID uuid) {
        City city = cityService.deleteCity(uuid);
        return ResponseEntity.ok(CityToCityDTOConverter.convert(city));
    }
}
