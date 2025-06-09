package com.dauphinesitn.customer_service.service.impl;

import com.dauphinesitn.customer_service.dto.CustomerDTO;
import com.dauphinesitn.customer_service.model.Customer;
import com.dauphinesitn.customer_service.repository.CustomerRepository;
import com.dauphinesitn.customer_service.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    @Override
    public Customer getCustomerById(UUID uuid) {
        return customerRepository.findById(uuid).orElse(null);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer createCustomer(CustomerDTO customerDTO) {
        Customer customer = Customer.builder()
                .uuid(UUID.randomUUID())
                .firstname(customerDTO.firstname())
                .surname(customerDTO.surname())
                .email(customerDTO.email())
                .build();
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(CustomerDTO customerDTO) {
        Customer customer = customerRepository.findById(customerDTO.uuid())
                .orElseThrow(() -> new IllegalArgumentException("Customer not found"));
        customer.setFirstname(customerDTO.firstname());
        customer.setSurname(customerDTO.surname());
        customer.setEmail(customerDTO.email());
        return customerRepository.save(customer);
    }

    @Override
    public Customer deleteCustomer(UUID uuid) {
        Customer customer = customerRepository.findById(uuid)
                .orElseThrow(() -> new IllegalArgumentException("Customer not found"));
        customerRepository.delete(customer);
        return customer;
    }
}
