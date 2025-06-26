package com.dauphinesitn.reservation_service.mapper;

import com.dauphinesitn.reservation_service.dto.PriceDTO;
import com.dauphinesitn.reservation_service.model.Price;

public class PriceMapper {

    public static PriceDTO toDto(Price price) {
        return PriceDTO.builder()
                .currencyId(price.getCurrencyId())
                .amount(price.getAmount())
                .build();
    }

    public static Price toEntity(PriceDTO price) {
        return Price.builder()
                .currencyId(price.currencyId())
                .amount(price.amount())
                .build();
    }
}
