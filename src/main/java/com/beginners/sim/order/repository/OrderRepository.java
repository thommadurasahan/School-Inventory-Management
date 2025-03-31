package com.beginners.sim.order.repository;

import com.beginners.sim.order.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    // Custom query to find orders by status
    @Query(value = "SELECT * FROM orders WHERE status = :status", nativeQuery = true)
    List<Order> findOrdersByStatus(@Param("status") String status);
}


