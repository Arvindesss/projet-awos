package com.dauphinesitn.search_service.services;

import com.dauphinesitn.search_service.dto.FlightSearchParameters;
import com.dauphinesitn.search_service.dto.FlightSearchResult;

import java.util.List;

public interface FlightSearchService {

    List<FlightSearchResult> searchFlights(FlightSearchParameters flightSearchParameters);
}
