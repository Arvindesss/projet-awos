package com.dauphinesitn.customer_service;

import com.dauphinesitn.customer_service.model.CardId;
import com.dauphinesitn.customer_service.model.Customer;
import com.dauphinesitn.customer_service.repository.CustomerRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

@Component
public class DataInitializer {

    private final CustomerRepository customerRepository;

    @Autowired
    public DataInitializer(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @PostConstruct
    public void init() {
        // Création d'un Customer avec CardId

        UUID customerUuid = UUID.fromString("11111111-1111-1111-1111-111111111111");
        UUID cardUuid = UUID.fromString("11111111-1111-1111-1111-111111111111");

        Customer customer = Customer.builder()
                .customerId(customerUuid)
                .firstname("Isco")
                .surname("Dupont")
                .email("isco.dupont@example.com")
                .build();

        CardId cardId = CardId.builder()
                .cardId(cardUuid)
                .customer(customer)  // liaison vers customer
                .build();

        // Affecter le CardId au Customer (important pour la bidirection)
        customer.setCardId(cardId);

        // Sauvegarde via customerRepository
        customerRepository.save(customer);


        UUID customerUuid2 = UUID.fromString("22222222-2222-2222-2222-222222222222");
        UUID cardUuid2 = UUID.fromString("22222222-2222-2222-2222-222222222222");

        Customer customer2 = Customer.builder()
                .customerId(customerUuid2)
                .firstname("Alice")
                .surname("Dupont")
                .email("alice.dupont@example.com")
                .build();

        CardId cardId2 = CardId.builder()
                .cardId(cardUuid2)
                .customer(customer2)  // liaison vers customer
                .build();

        // Affecter le CardId au Customer (important pour la bidirection)
        customer2.setCardId(cardId2);

        // Sauvegarde via customerRepository
        customerRepository.save(customer2);
    }
}
