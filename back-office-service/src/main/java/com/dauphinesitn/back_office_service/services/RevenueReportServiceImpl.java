package com.dauphinesitn.back_office_service.services;

import com.dauphinesitn.back_office_service.client.PaymentClient;
import com.dauphinesitn.back_office_service.dto.MonthlyRevenueDTO;
import com.dauphinesitn.back_office_service.dto.PaymentDTO;
import com.dauphinesitn.back_office_service.dto.RevenueReportDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Month;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RevenueReportServiceImpl implements RevenueReportService {

    private final PaymentClient paymentClient;

    @Override
    public RevenueReportDTO generateRevenueReport(RevenueReportDTO revenueReportDTO) {
        List<PaymentDTO> paymentsByYear = paymentClient.getAllPayments(revenueReportDTO.year()).getBody();

        Map<Month, Double> monthlySums = paymentsByYear.stream()
                .collect(Collectors.groupingBy(
                        p -> p.paymentDate().getMonth(),
                        Collectors.summingDouble(PaymentDTO::amount)
                ));

        List<MonthlyRevenueDTO> monthlyRevenues = Arrays.stream(Month.values())
                .map(month -> new MonthlyRevenueDTO(
                        month,
                        monthlySums.getOrDefault(month, 0.0)
                ))
                .toList();

        double total = monthlyRevenues.stream()
                .mapToDouble(MonthlyRevenueDTO::totalAmount)
                .sum();

        return RevenueReportDTO.builder()
                .year(revenueReportDTO.year())
                .currency(revenueReportDTO.currency())
                .monthlyRevenues(monthlyRevenues)
                .totalYearlyRevenue(total)
                .build();
    }
}
