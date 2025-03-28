package com.rest.springapp.service;

import com.rest.springapp.model.Admin;
import com.rest.springapp.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    // Get all admins with pagination and sorting
    public List<Admin> getAllAdmins(int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Order.asc(sortBy)));
        return adminRepository.findAll(pageable).getContent();
    }

    // Get all admins without sorting
    public List<Admin> getAllAdmins(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return adminRepository.findAll(pageable).getContent();
    }
    public List<Admin> searchAdminsByUsername(String username) {
        return AdminRepository.findByRole(username);
    }
    
    // Get admin by ID
    public Optional<Admin> getAdminById(Long id) {
        return adminRepository.findById(id);
    }

    // Create admin
    public Admin createAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    // Update admin
    public Admin updateAdmin(Long id, Admin admin) {
        if (adminRepository.existsById(id)) {
            admin.setAdminID(id);
            return adminRepository.save(admin);
        }
        return null;
    }

    // Delete admin
    public boolean deleteAdmin(Long id) {
        if (adminRepository.existsById(id)) {
            adminRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
