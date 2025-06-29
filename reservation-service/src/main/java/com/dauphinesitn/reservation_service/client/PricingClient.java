package com.dauphinesitn.reservation_service.client;

import com.dauphinesitn.reservation_service.dto.ItineraryPricingDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "pricing-service")
public interface PricingClient {

    @GetMapping("/v1/itinerary-pricing/airport-ids")
    ResponseEntity<ItineraryPricingDTO> getItineraryPricingByAirportIds(@RequestBody ItineraryPricingDTO itineraryPricingDTO);

}
