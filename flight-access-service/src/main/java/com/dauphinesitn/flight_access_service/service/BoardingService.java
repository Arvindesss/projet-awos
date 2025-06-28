package com.dauphinesitn.flight_access_service.service;

import com.dauphinesitn.flight_access_service.dto.BoardingDTO;
import com.dauphinesitn.flight_access_service.model.Boarding;

import java.util.List;
import java.util.UUID;

public interface BoardingService {

    List<Boarding> getAllBoardings();

    Boarding getBoardingById(UUID id);

    Boarding createBoarding(BoardingDTO checkIn);

    Boarding deleteBoarding(UUID id);
}
