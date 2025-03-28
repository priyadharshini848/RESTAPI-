package com.rest.springapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.rest.springapp.model.Category;
import com.rest.springapp.repository.CategoryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {   

    @Autowired
    private CategoryRepository categoryRepository;

    // CRUD Operations  

    // Get all Categories with pagination and sorting
    public Page<Category> getCategories(int page, int size, String sortBy, String sortDir) {
        Pageable pageable = PageRequest.of(page, size, sortDir.equalsIgnoreCase("asc") ?
                org.springframework.data.domain.Sort.by(sortBy).ascending() :
                org.springframework.data.domain.Sort.by(sortBy).descending());
        return categoryRepository.findAll(pageable);
    }

    // Get a Category by ID
    public Optional<Category> getCategoryById(Long id) {
        return categoryRepository.findById(id);
    }

    // Create a new Category
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    // Update an existing Category
    public Category updateCategory(Long id, Category category) {
        if (categoryRepository.existsById(id)) {
            category.setId(id); // Ensure the ID is set before saving
            return categoryRepository.save(category);
        }
        return null; // Return null if category doesn't exist
    }

    // Delete a Category
    public boolean deleteCategory(Long id) {
        if (categoryRepository.existsById(id)) {
            categoryRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // Find Categories by Name using JPQL
    public List<Category> findCategoriesByName(String name) {
        return categoryRepository.findByNameLike(name);
    }

    // Count Categories by Name using JPQL
    public long countCategoriesByName(String name) {
        return categoryRepository.countByNameLike(name);
    }
}
