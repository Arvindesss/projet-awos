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

        UUID customerUuid = UUID.fromString("d56c4690-bb7c-45ec-8db8-7545702b259c");
        UUID cardUuid = UUID.fromString("a1b2c3d4-e5f6-7g8h-9i0j-k1l2m3n4o5p6");

        Customer customer = Customer.builder()
                .uuid(customerUuid)
                .firstname("Alice")
                .surname("Dupont")
                .email("alice.dupont@example.com")
                .build();

        CardId cardId = CardId.builder()
                .cardId(cardUuid)
                .customer(customer)  // liaison vers customer
                .build();

        // Affecter le CardId au Customer (important pour la bidirection)
        customer.setCardId(cardId);

        // Sauvegarde via customerRepository
        customerRepository.save(customer);

        // Grâce au cascade ALL, CardId sera aussi persisté automatiquement
    }
}
