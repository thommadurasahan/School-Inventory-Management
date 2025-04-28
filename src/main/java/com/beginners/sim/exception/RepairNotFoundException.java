package com.beginners.sim.exception;

public class RepairNotFoundException extends RuntimeException {

    public RepairNotFoundException() {
        super("Repair not found");
    }

    public RepairNotFoundException(String message) {
        super(message);
    }

    public RepairNotFoundException(int id) {
        super(String.format("Repair with ID %d not found", id));
    }

    public RepairNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public RepairNotFoundException(Throwable cause) {
        super("Repair not found", cause);
    }
}