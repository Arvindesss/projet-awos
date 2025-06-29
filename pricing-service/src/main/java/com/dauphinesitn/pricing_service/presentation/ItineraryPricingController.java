package com.dauphinesitn.pricing_service.presentation;

import com.dauphinesitn.pricing_service.dto.ItineraryPricingDTO;
import com.dauphinesitn.pricing_service.mapper.ItineraryPricingMapper;
import com.dauphinesitn.pricing_service.model.ItineraryPricing;
import com.dauphinesitn.pricing_service.service.ItineraryPricingService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/itinerary-pricing")
@AllArgsConstructor
public class ItineraryPricingController {

    private ItineraryPricingService itineraryPricingService;

    @GetMapping("")
    public ResponseEntity<List<ItineraryPricingDTO>> getAllItineraryPricings() {
        List<ItineraryPricing> itineraryPricings = itineraryPricingService.getAllItineraryPricings();
        return ResponseEntity.ok(ItineraryPricingMapper.toDTO(itineraryPricings));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItineraryPricingDTO> getItineraryPricingById(@PathVariable UUID id) {
        ItineraryPricing itineraryPricing = itineraryPricingService.getItineraryPricingById(id);
        return ResponseEntity.ok(ItineraryPricingMapper.toDTO(itineraryPricing));
    }

    @GetMapping("/airport-ids")
    public ResponseEntity<ItineraryPricingDTO> getItineraryPricingByAirportIds(@RequestBody ItineraryPricingDTO itineraryPricingDTO) {
        ItineraryPricing itineraryPricing = itineraryPricingService.getItineraryPricingByAirportIds(itineraryPricingDTO.arrivalAirportId(), itineraryPricingDTO.departureAirportId());
        return ResponseEntity.ok(ItineraryPricingMapper.toDTO(itineraryPricing));
    }


    @PostMapping("/create")
    public ResponseEntity<ItineraryPricingDTO> createItineraryPricing(@RequestBody ItineraryPricingDTO itineraryPricingDTO) {
        ItineraryPricing createdItineraryPricing = itineraryPricingService.createItineraryPricing(itineraryPricingDTO);
        return ResponseEntity.ok(ItineraryPricingMapper.toDTO(createdItineraryPricing));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ItineraryPricingDTO> updateItineraryPricing(@PathVariable UUID id, @RequestBody ItineraryPricingDTO updatedPricing) {
        ItineraryPricing updatedItineraryPricing = itineraryPricingService.updateItineraryPricing(id, updatedPricing);
        return ResponseEntity.ok(ItineraryPricingMapper.toDTO(updatedItineraryPricing));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ItineraryPricingDTO> deleteItineraryPricing(@PathVariable UUID id) {
        ItineraryPricing deletedItineraryPricing = itineraryPricingService.deleteItineraryPricing(id);
        return ResponseEntity.ok(ItineraryPricingMapper.toDTO(deletedItineraryPricing));
    }
}
