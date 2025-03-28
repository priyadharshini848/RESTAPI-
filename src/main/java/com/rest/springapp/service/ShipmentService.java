package com.rest.springapp.service;

import com.rest.springapp.model.Shipment;
import com.rest.springapp.repository.ShipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShipmentService {

    @Autowired
    private ShipmentRepository shipmentRepository;

    public Shipment createShipment(Shipment shipment) {
        return shipmentRepository.save(shipment);
    }

    public List<Shipment> getAllShipments() {
        return shipmentRepository.findAll();
    }

    public Optional<Shipment> getShipmentById(Long id) {
        return shipmentRepository.findById(id);
    }

    public Shipment updateShipment(Long id, Shipment updatedShipment) {
        if (shipmentRepository.existsById(id)) {
            updatedShipment.setId(id);
            return shipmentRepository.save(updatedShipment);
        }
        return null;
    }

    public void deleteShipment(Long id) {
        shipmentRepository.deleteById(id);
    }
}
