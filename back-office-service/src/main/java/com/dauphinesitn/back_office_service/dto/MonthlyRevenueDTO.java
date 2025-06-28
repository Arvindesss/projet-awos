package com.dauphinesitn.back_office_service.dto;

import lombok.Builder;

import java.time.Month;

@Builder
public record MonthlyRevenueDTO(Month month, double totalAmount) { }