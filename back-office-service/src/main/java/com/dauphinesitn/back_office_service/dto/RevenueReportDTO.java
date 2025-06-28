package com.dauphinesitn.back_office_service.dto;

import lombok.Builder;

import java.util.List;

@Builder
public record RevenueReportDTO(
        int year,
        String currency,
        List<MonthlyRevenueDTO> monthlyRevenues,
        double totalYearlyRevenue
) { }