package com.rest.springapp.repository;

import com.rest.springapp.model.Admin;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface AdminRepository extends JpaRepository<Admin, Long> {

    // JPQL Query to find admins by role
    @Query("SELECT a FROM Admin a WHERE a.role = ?1")
    static
    List<Admin> findByRole(String role) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByRole'");
    }

    // JPQL Query to count admins by role
    @Query("SELECT COUNT(a) FROM Admin a WHERE a.role = ?1")
    static
    long countByRole(String role) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'countByRole'");
    }

    // Pagination support (by default)
    @SuppressWarnings("null")
    Page<Admin> findAll(Pageable pageable);
}
