package com.dauphinesitn.customer_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CardId {

    @Id
    private UUID cardId;

    @OneToOne
    @JoinColumn(name = "customer_id", unique = true)
    private Customer customer;
}
