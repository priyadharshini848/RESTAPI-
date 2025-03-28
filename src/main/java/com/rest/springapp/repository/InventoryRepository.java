package com.rest.springapp.repository;

import com.rest.springapp.model.Inventory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {

    // JPQL: Find inventories with stock level less than a given value
    @Query("SELECT i FROM Inventory i WHERE i.stockLevel < ?1")
    List<Inventory> findByStockLevelLessThan(int stockLevel);

    // JPQL: Count inventories with stock level greater than a given value
    @Query("SELECT COUNT(i) FROM Inventory i WHERE i.stockLevel > ?1")
    long countByStockLevelGreaterThan(int stockLevel);

    // Pagination with sorting is handled automatically by JpaRepository
    @SuppressWarnings("null")
    Page<Inventory> findAll(Pageable pageable);
}
