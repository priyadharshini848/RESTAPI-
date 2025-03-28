package com.rest.springapp.service;

import com.rest.springapp.model.Inventory;
import com.rest.springapp.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    // Get all inventories with pagination and sorting
    public List<Inventory> getAllInventories(int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return inventoryRepository.findAll(pageable).getContent();
    }

    // Get all inventories with pagination (without sorting)
    public List<Inventory> getAllInventories(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return inventoryRepository.findAll(pageable).getContent();
    }

    // Get inventory by ID
    public Optional<Inventory> getInventoryById(Long id) {
        return inventoryRepository.findById(id);
    }

    // Create inventory
    public Inventory createInventory(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    // Update inventory
    public Inventory updateInventory(Long id, Inventory inventory) {
        if (inventoryRepository.existsById(id)) {
            inventory.setInventoryID(id);
            return inventoryRepository.save(inventory);
        }
        return null;
    }

    // Delete inventory
    public boolean deleteInventory(Long id) {
        if (inventoryRepository.existsById(id)) {
            inventoryRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // Find inventories with stock level less than a value
    public List<Inventory> findByStockLevelLessThan(int stockLevel) {
        return inventoryRepository.findByStockLevelLessThan(stockLevel);
    }

    // Count inventories with stock level greater than a value
    public long countByStockLevelGreaterThan(int stockLevel) {
        return inventoryRepository.countByStockLevelGreaterThan(stockLevel);
    }
}
