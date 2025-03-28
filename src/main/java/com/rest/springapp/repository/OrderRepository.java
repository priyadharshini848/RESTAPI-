package com.rest.springapp.repository;

import com.rest.springapp.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query("SELECT o FROM Order o WHERE o.status = ?1")
    List<Order> findByStatus(String status);

    @Query("SELECT COUNT(o) FROM Order o WHERE o.status = ?1")
    long countByStatus(String status);
}
