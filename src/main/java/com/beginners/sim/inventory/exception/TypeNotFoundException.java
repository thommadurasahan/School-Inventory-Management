package com.beginners.sim.inventory.exception;

import com.beginners.sim.common.exception.NotFoundException;

public class TypeNotFoundException extends NotFoundException {

    public TypeNotFoundException() {
        super();
    }

    public TypeNotFoundException(String message) {
        super(message);
    }

    public TypeNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public TypeNotFoundException(Throwable cause) {
        super(cause);
    }
}