package com.rest.springapp.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rest.springapp.model.Category;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    // Pagination and sorting: Find all categories with pagination and sorting
    @SuppressWarnings("null")
    Page<Category> findAll(Pageable pageable);

    // Custom JPQL query: Find categories by name (using JPQL)
    @Query("SELECT c FROM Category c WHERE c.name LIKE %?1%")
    List<Category> findByNameLike(String name);

    // Custom JPQL query: Count categories by name
    @Query("SELECT COUNT(c) FROM Category c WHERE c.name LIKE %?1%")
    long countByNameLike(String name);
}
