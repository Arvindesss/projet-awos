package com.dauphinesitn.customer_service.presentation;

import com.dauphinesitn.customer_service.dto.CustomerDTO;
import com.dauphinesitn.customer_service.dto.converter.CustomerToCustomerDTOConverter;
import com.dauphinesitn.customer_service.model.Customer;
import com.dauphinesitn.customer_service.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/customers")
@AllArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable UUID id) {
        Customer customer = customerService.getCustomerById(id);
        return ResponseEntity.ok(CustomerToCustomerDTOConverter.convert(customer));
    }

    @GetMapping("/card/{cardId}")
    public ResponseEntity<CustomerDTO> getCustomerByCardId(@PathVariable UUID cardId) {
        Customer customer = customerService.getCustomerByCardId(cardId);
        return ResponseEntity.ok(CustomerToCustomerDTOConverter.convert(customer));
    }

    @GetMapping("")
    public ResponseEntity<List<CustomerDTO>> getAllCustomers() {
        List<Customer> customers = customerService.getAllCustomers();
        List<CustomerDTO> customerDTOs = customers.stream()
                .map(CustomerToCustomerDTOConverter::convert)
                .collect(Collectors.toList());
        return ResponseEntity.ok(customerDTOs);
    }

    @PostMapping("/create")
    public ResponseEntity<CustomerDTO> createCustomer(@RequestBody CustomerDTO customerDTO) {
        Customer customer = customerService.createCustomer(customerDTO);
        return ResponseEntity.created(URI.create("/v1/customers/" + customer.getUuid()))
                .body(CustomerToCustomerDTOConverter.convert(customer));
    }

    @PutMapping("/update")
    public ResponseEntity<CustomerDTO> updateCustomer(@RequestBody CustomerDTO customerDTO) {
        Customer customer = customerService.updateCustomer(customerDTO);
        return ResponseEntity.created(URI.create("/v1/customers/" + customer.getUuid()))
                .body(CustomerToCustomerDTOConverter.convert(customer));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<CustomerDTO> deleteCustomer(@PathVariable UUID id) {
        Customer customer = customerService.deleteCustomer(id);
        return ResponseEntity.ok(CustomerToCustomerDTOConverter.convert(customer));
    }
}
