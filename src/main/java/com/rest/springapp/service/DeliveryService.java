package com.rest.springapp.service;

import com.rest.springapp.model.Delivery;
import com.rest.springapp.model.Shipment;
import com.rest.springapp.repository.DeliveryRepository;
import com.rest.springapp.repository.ShipmentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeliveryService {

    @Autowired
    private DeliveryRepository deliveryRepository;

    @Autowired
    private ShipmentRepository shipmentRepository;

    public Delivery createDeliveryForShipment(Long shipmentId, Delivery delivery) {
        Optional<Shipment> shipment = shipmentRepository.findById(shipmentId);
        if (shipment.isPresent()) {
            delivery.setShipment(shipment.get());
            return deliveryRepository.save(delivery);
        }
        return null;
    }

    public List<Delivery> getAllDeliveries() {
        return deliveryRepository.findAll();
    }

    public Optional<Delivery> getDeliveryById(Long id) {
        return deliveryRepository.findById(id);
    }

    public void deleteDelivery(Long id) {
        deliveryRepository.deleteById(id);
    }
}
