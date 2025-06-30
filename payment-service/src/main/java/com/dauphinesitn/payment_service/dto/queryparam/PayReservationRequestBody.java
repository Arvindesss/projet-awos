package com.dauphinesitn.payment_service.dto.queryparam;

import java.time.LocalDateTime;
import java.util.UUID;

public record PayReservationRequestBody(UUID reservationId,
                                        UUID customerId,
                                        String description,
                                        Double amount,
                                        String currency,
                                        LocalDateTime paymentDate) {
}
