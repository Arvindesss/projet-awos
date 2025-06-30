package com.dauphinesitn.location_service.presentation;

import com.dauphinesitn.location_service.dto.CountryDTO;
import com.dauphinesitn.location_service.mapper.CountryMapper;
import com.dauphinesitn.location_service.model.Country;
import com.dauphinesitn.location_service.service.CountryService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/countries")
@AllArgsConstructor
public class CountryController {

    private final CountryService countryService;

    @GetMapping("")
    public ResponseEntity<List<CountryDTO>> getAllCountries() {
        List<Country> countries = countryService.getAllCountries();
        return ResponseEntity.ok(CountryMapper.toDTO(countries));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CountryDTO> getCountryById(@PathVariable UUID id) {
        Country country = countryService.getCountryById(id);
        return ResponseEntity.ok(CountryMapper.toDTO(country));
    }

    @GetMapping("/name")
    public ResponseEntity<CountryDTO> getCountryByName(@RequestParam String countryName) {
        Country country = countryService.getCountryByName(countryName);
        return ResponseEntity.ok(CountryMapper.toDTO(country));
    }

    @PostMapping("/create")
    public ResponseEntity<CountryDTO> createCountry(@RequestBody CountryDTO countryDTO) {
        Country createdCountry = countryService.createCountry(countryDTO);
        return ResponseEntity.created(URI.create("/v1/countries/" + createdCountry.getUuid())).body(CountryMapper.toDTO(createdCountry));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCountry(@PathVariable UUID id) {
        countryService.deleteCountry(id);
        return ResponseEntity.ok().build();
    }
}
