package com.dauphinesitn.back_office_service.presentation;

import com.dauphinesitn.back_office_service.dto.RevenueReportDTO;
import com.dauphinesitn.back_office_service.services.RevenueReportService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/revenue-reports")
@AllArgsConstructor
public class RevenueReportController {

    private final RevenueReportService revenueReportService;

    @GetMapping("/monthly-revenue")
    public ResponseEntity<RevenueReportDTO> getMonthlyRevenueReport(@RequestBody RevenueReportDTO revenueReportDTO) {
        RevenueReportDTO revenueReport = revenueReportService.generateRevenueReport(revenueReportDTO);
        return ResponseEntity.ok(revenueReport);
    }

}
