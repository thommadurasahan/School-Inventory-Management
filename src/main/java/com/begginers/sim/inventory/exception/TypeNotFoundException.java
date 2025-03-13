package com.begginers.sim.inventory.exception;

public class TypeNotFoundException extends Exception {

    public TypeNotFoundException() {
        super();
    }

    public TYpeNotFoundException(String message) {
        super(message);
    }

    public TypeNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public TypeNotFoundException(Throwable cause) {
        super(cause);
    }
}