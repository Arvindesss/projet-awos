package com.dauphinesitn.customer_service.service;

import com.dauphinesitn.customer_service.dto.CustomerDTO;
import com.dauphinesitn.customer_service.model.Customer;

import java.util.List;
import java.util.UUID;

public interface CustomerService {

    Customer getCustomerById(UUID uuid);

    Customer getCustomerByCardId(UUID cardId);

    List<Customer> getAllCustomers();

    Customer createCustomer(CustomerDTO customerDTO);

    Customer updateCustomer(CustomerDTO customerDTO);

    Customer deleteCustomer(UUID uuid);
}
