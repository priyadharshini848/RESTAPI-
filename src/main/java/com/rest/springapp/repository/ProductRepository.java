package com.rest.springapp.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rest.springapp.model.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    // Pagination and sorting: Find all products with pagination and sorting
    @SuppressWarnings("null")
    @Override
    Page<Product> findAll(Pageable pageable);

    // Custom JPQL query: Find products by name (using JPQL)
    @Query("SELECT p FROM Product p WHERE p.name LIKE %?1%")
    List<Product> findByNameLike(String name);

    // Custom JPQL query: Count products by name
    @Query("SELECT COUNT(p) FROM Product p WHERE p.name LIKE %?1%")
    long countByNameLike(String name);
}
   