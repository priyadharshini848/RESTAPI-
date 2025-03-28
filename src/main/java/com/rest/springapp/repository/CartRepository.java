package com.rest.springapp.repository;

import com.rest.springapp.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Long> {

    @Query("SELECT c FROM Cart c WHERE c.uniqueAttribute = ?1")
    List<Cart> findByUniqueAttribute(String uniqueAttribute);

    @SuppressWarnings("null")
    Page<Cart> findAll(Pageable pageable);
}
