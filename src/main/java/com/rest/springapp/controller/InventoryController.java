package com.rest.springapp.controller;

import com.rest.springapp.model.Inventory;
import com.rest.springapp.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/inventories")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    // GET: All inventories with pagination and optional sorting
    @GetMapping
    public List<Inventory> getAllInventories(@RequestParam int page, @RequestParam int size, @RequestParam(required = false) String sortBy) {
        return (sortBy == null) ? inventoryService.getAllInventories(page, size) : inventoryService.getAllInventories(page, size, sortBy);
    }

    // GET: Inventory by ID
    @GetMapping("/{id}")
    public Optional<Inventory> getInventoryById(@PathVariable Long id) {
        return inventoryService.getInventoryById(id);
    }

    // POST: Create inventory
    @PostMapping
    public Inventory createInventory(@RequestBody Inventory inventory) {
        return inventoryService.createInventory(inventory);
    }

    // PUT: Update inventory
    @PutMapping("/{id}")
    public Inventory updateInventory(@PathVariable Long id, @RequestBody Inventory inventory) {
        return inventoryService.updateInventory(id, inventory);
    }

    // DELETE: Delete inventory
    @DeleteMapping("/{id}")
    public boolean deleteInventory(@PathVariable Long id) {
        return inventoryService.deleteInventory(id);
    }

    // GET: Inventories with stock level less than a given value
    @GetMapping("/low-stock")
    public List<Inventory> getLowStockInventories(@RequestParam int stockLevel) {
        return inventoryService.findByStockLevelLessThan(stockLevel);
    }

    // GET: Count of inventories with stock level greater than a value
    @GetMapping("/count/high-stock")
    public long countHighStockInventories(@RequestParam int stockLevel) {
        return inventoryService.countByStockLevelGreaterThan(stockLevel);
    }
}
