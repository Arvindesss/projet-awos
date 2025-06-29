package com.dauphinesitn.pricing_service.repository;

import com.dauphinesitn.pricing_service.model.ItineraryPricing;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ItineraryPricingRepository extends JpaRepository<ItineraryPricing, UUID> {
}
