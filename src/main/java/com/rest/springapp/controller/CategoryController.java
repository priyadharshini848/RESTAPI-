package com.rest.springapp.controller;

import com.rest.springapp.model.Category;
import com.rest.springapp.service.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    // CRUD Operations

    // Get all Categories with pagination and sorting
    @GetMapping
    public Page<Category> getCategories(
            @RequestParam int page, 
            @RequestParam int size, 
            @RequestParam String sortBy, 
            @RequestParam String sortDir) {
        return categoryService.getCategories(page, size, sortBy, sortDir);
    }

    // Get a Category by ID
    @GetMapping("/{id}")
    public Optional<Category> getCategoryById(@PathVariable Long id) {
        return categoryService.getCategoryById(id);
    }

    // Create a new Category
    @PostMapping
    public Category createCategory(@RequestBody Category category) {
        return categoryService.createCategory(category);
    }

    // Update an existing Category
    @PutMapping("/{id}")
    public Category updateCategory(@PathVariable Long id, @RequestBody Category category) {
        return categoryService.updateCategory(id, category);
    }

    // Delete a Category
    @DeleteMapping("/{id}")
    public boolean deleteCategory(@PathVariable Long id) {
        return categoryService.deleteCategory(id);
    }

    // Find Categories by Name using JPQL
    @GetMapping("/search")
    public List<Category> findCategoriesByName(@RequestParam String name) {
        return categoryService.findCategoriesByName(name);
    }

    // Count Categories by Name using JPQL
    @GetMapping("/count")
    public long countCategoriesByName(@RequestParam String name) {
        return categoryService.countCategoriesByName(name);
    }
}
