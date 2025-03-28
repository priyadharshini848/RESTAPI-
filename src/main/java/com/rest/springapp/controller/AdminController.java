package com.rest.springapp.controller;

import com.rest.springapp.model.Admin;
import com.rest.springapp.repository.AdminRepository;
import com.rest.springapp.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/admins")
public class AdminController {

    @Autowired
    private AdminService adminService;

    // Get all admins with pagination and optional sorting
    @GetMapping
    public List<Admin> getAllAdmins(@RequestParam int page, @RequestParam int size, @RequestParam(required = false) String sortBy) {
        if (sortBy == null) {
            return adminService.getAllAdmins(page, size);
        } else {
            return adminService.getAllAdmins(page, size, sortBy);      
        } 
    }

    // Search admins by username (JPQL Query)
@GetMapping("/search")
public List<Admin> searchAdminsByUsername(@RequestParam String username) {
    return adminService.searchAdminsByUsername(username);
}

    // Get admin by ID
    @GetMapping("/{id}")
    public Optional<Admin> getAdminById(@PathVariable Long id) {
        return adminService.getAdminById(id);
    }

    // Create admin
    @PostMapping
    public Admin createAdmin(@RequestBody Admin admin) {
        return adminService.createAdmin(admin);
    }

    // Update admin
    @PutMapping("/{id}")
    public Admin updateAdmin(@PathVariable Long id, @RequestBody Admin admin) {
        return adminService.updateAdmin(id, admin);
    }

    // Delete admin
    @DeleteMapping("/{id}")
    public boolean deleteAdmin(@PathVariable Long id) {
        return adminService.deleteAdmin(id);
    }

    // Get admins by role (JPQL Query)
    @GetMapping("/role")
    public List<Admin> getAdminsByRole(@RequestParam String role) {
        return AdminRepository.findByRole(role);
    }

    // Get count of admins by role (JPQL Query)
    @GetMapping("/count/role")
    public long countAdminsByRole(@RequestParam String role) {
        return AdminRepository.countByRole(role);
    }
}
