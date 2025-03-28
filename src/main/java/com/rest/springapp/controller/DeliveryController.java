package com.rest.springapp.controller;

import com.rest.springapp.model.Delivery;
import com.rest.springapp.service.DeliveryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/deliveries")
public class DeliveryController {

    @Autowired
    private DeliveryService deliveryService;

    @PostMapping("/shipment/{shipmentId}")
    public Delivery createDeliveryForShipment(
            @PathVariable Long shipmentId,
            @RequestBody Delivery delivery) {
        return deliveryService.createDeliveryForShipment(shipmentId, delivery);
    }

    @GetMapping
    public List<Delivery> getAllDeliveries() {
        return deliveryService.getAllDeliveries();
    }

    @GetMapping("/{id}")
    public Optional<Delivery> getDeliveryById(@PathVariable Long id) {
        return deliveryService.getDeliveryById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteDelivery(@PathVariable Long id) {
        deliveryService.deleteDelivery(id);
    }
}
