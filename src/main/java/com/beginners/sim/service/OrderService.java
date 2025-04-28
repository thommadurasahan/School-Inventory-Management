package com.beginners.sim.service;

import com.beginners.sim.model.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface OrderService {
    Page<Order> getAllOrders(Pageable pageable);

    Optional<Order> getOrderById(Long id);

    Order saveOrder(Order order);

    void deleteOrder(Long id);
}