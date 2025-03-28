package com.rest.springapp.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Shipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String origin;
    private String destination;
    private String shipmentDate;
    private String estimatedDeliveryDate;
    private String status;  // e.g., "Pending", "In Transit", "Delivered"
    private double weight;
    private double volume;
    private double cost;
}
