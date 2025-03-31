package com.beginners.sim.order.controller;

import com.beginners.sim.common.util.Constant;
import com.beginners.sim.order.exception.OrderNotFoundException;
import com.beginners.sim.order.model.Order;
import com.beginners.sim.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(Constant.Order_BASE_URL)
@RequiredArgsConstructor
@Slf4j
public class OrderController {

    private final OrderService orderService;

    public OrderController() {
        orderService = null;
    }

    @GetMapping
    public Page<Order> getAllOrders(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return orderService.getAllOrders(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long id) throws OrderNotFoundException {
        Optional<Order> order = orderService.getOrderById(id);
        String ORDER_NOT_FOUND_MESSAGE = null;
        try {
            return order.map(ResponseEntity::ok)
                    .orElseThrow(() -> new OrderNotFoundException(ORDER_NOT_FOUND_MESSAGE + id));
        } catch (OrderNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        return orderService.saveOrder(order);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
        return ResponseEntity.noContent().build();
    }
}