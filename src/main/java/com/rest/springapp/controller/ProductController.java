package com.rest.springapp.controller;

import com.rest.springapp.model.Product;
import com.rest.springapp.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    // CRUD Operations

    // Get all Products with pagination and sorting
    @GetMapping
    public Page<Product> getProducts(
            @RequestParam int page, 
            @RequestParam int size, 
            @RequestParam String sortBy, 
            @RequestParam String sortDir) {
        return productService.getProducts(page, size, sortBy, sortDir);
    }

    // Get a Product by ID
    @GetMapping("/{id}")
    public Optional<Product> getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    // Create a new Product
    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    // Update an existing Product
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }

    // Delete a Product
    @DeleteMapping("/{id}")
    public boolean deleteProduct(@PathVariable Long id) {
        return productService.deleteProduct(id);
    }

    // Find Products by Name using JPQL
    @GetMapping("/search")
    public List<Product> findProductsByName(@RequestParam String name) {
        return productService.findProductsByName(name);
    }

    // Count Products by Name using JPQL
    @GetMapping("/count")
    public long countProductsByName(@RequestParam String name) {
        return productService.countProductsByName(name);
    }
}
