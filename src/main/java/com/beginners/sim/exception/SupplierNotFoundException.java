package com.beginners.sim.exception;

public class SupplierNotFoundException extends NotFoundException {

    public SupplierNotFoundException() {
        super();
    }

    public SupplierNotFoundException(String message) {
        super(message);
    }

    public SupplierNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public SupplierNotFoundException(Throwable cause) {
        super(cause);
    }
}
