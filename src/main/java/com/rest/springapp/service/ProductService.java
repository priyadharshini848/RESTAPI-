package com.rest.springapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.rest.springapp.model.Product;
import com.rest.springapp.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // CRUD Operations

    // Get all Products with pagination and sorting
    public Page<Product> getProducts(int page, int size, String sortBy, String sortDir) {
        Pageable pageable = PageRequest.of(page, size, sortDir.equalsIgnoreCase("asc") ?
                org.springframework.data.domain.Sort.by(sortBy).ascending() :
                org.springframework.data.domain.Sort.by(sortBy).descending());
        return productRepository.findAll(pageable);
    }

    // Get a Product by ID
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    // Create a new Product
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    // Update an existing Product
    public Product updateProduct(Long id, Product product) {
        if (productRepository.existsById(id)) {
            product.setId(id); // Ensure the ID is set before saving
            return productRepository.save(product);
        }
        return null; // Return null if product doesn't exist
    }

    // Delete a Product
    public boolean deleteProduct(Long id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // Find Products by Name using JPQL
    public List<Product> findProductsByName(String name) {
        return productRepository.findByNameLike(name);
    }

    // Count Products by Name using JPQL
    public long countProductsByName(String name) {
        return productRepository.countByNameLike(name);
    }
}
