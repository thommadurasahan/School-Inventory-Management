package com.beginners.sim.inventory.exception;

import com.beginners.sim.common.exception.NotFoundException;

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
