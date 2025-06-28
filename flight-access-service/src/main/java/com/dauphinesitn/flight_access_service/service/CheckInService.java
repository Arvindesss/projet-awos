package com.dauphinesitn.flight_access_service.service;

import com.dauphinesitn.flight_access_service.dto.CheckInDTO;
import com.dauphinesitn.flight_access_service.model.CheckIn;

import java.util.List;
import java.util.UUID;

public interface CheckInService {

    List<CheckIn> getAllCheckIns();

    CheckIn getCheckInById(UUID id);

    CheckIn createCheckIn(CheckInDTO checkIn);

    CheckIn deleteCheckIn(UUID id);
}
