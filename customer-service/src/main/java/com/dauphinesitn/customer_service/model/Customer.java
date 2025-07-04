package com.dauphinesitn.customer_service.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    private UUID customerId;

    private String firstname;

    private String surname;

    private String email;

    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
    private CardId cardId;
}
