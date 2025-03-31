package com.begginers.sim.order.exception;

public class OrderNotFoundException extends RuntimeException {
    public OrderNotFoundException(String message) {
        super(message);  // Allows passing custom error messages
    }
}