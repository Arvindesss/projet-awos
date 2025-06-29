package com.dauphinesitn.search_service.client;

import com.dauphinesitn.search_service.dto.ItineraryPricingDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "pricing-service")
public interface PricingClient {

    @GetMapping("/v1/pricing/itinerary-pricings/airport-ids")
    ResponseEntity<ItineraryPricingDTO> getItineraryPricingByAirportIds(@RequestBody ItineraryPricingDTO itineraryPricingDTO);

}
