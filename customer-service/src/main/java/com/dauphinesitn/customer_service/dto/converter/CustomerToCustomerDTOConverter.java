package com.dauphinesitn.customer_service.dto.converter;

import com.dauphinesitn.customer_service.dto.CustomerDTO;
import com.dauphinesitn.customer_service.model.Customer;

public class CustomerToCustomerDTOConverter {

    public static CustomerDTO convert(Customer customer) {
        return CustomerDTO.builder()
                .uuid(customer.getUuid())
                .firstname(customer.getFirstname())
                .surname(customer.getSurname())
                .email(customer.getEmail())
                .build();
    }
}
