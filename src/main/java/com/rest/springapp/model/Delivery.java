package com.rest.springapp.model;

import jakarta.persistence.*;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String recipient;
    private String origin;
    private String destination;
    private String deliveryDate;
    private String status;  // e.g., "Pending", "Delivered"

    @ManyToOne(fetch = FetchType.EAGER)   // Many deliveries → One shipment
    @JoinColumn(name = "shipment_id")
    @JsonIgnoreProperties("deliveries")   // Avoid infinite recursion
    private Shipment shipment;
}
