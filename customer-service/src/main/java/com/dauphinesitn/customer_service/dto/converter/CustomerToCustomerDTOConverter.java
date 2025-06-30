package com.dauphinesitn.customer_service.dto.converter;

import com.dauphinesitn.customer_service.dto.CardDTO;
import com.dauphinesitn.customer_service.dto.CustomerDTO;
import com.dauphinesitn.customer_service.model.Customer;

public class CustomerToCustomerDTOConverter {

    public static CustomerDTO convert(Customer customer) {
        return CustomerDTO.builder()
                .customerId(customer.getCustomerId())
                .firstname(customer.getFirstname())
                .surname(customer.getSurname())
                .email(customer.getEmail())
                .cardId(CardDTO.builder().cardId(customer.getCardId().getCardId()).build())
                .build();
    }
}
