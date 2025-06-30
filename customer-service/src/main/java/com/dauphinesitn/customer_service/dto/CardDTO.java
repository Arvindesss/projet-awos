package com.dauphinesitn.customer_service.dto;

import lombok.Builder;

import java.util.UUID;

@Builder
public record CardDTO (UUID cardId) {
}
