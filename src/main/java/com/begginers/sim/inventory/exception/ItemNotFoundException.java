package com.begginers.sim.inventory.exception;

import com.begginers.sim.common.exception.NotFoundException;

public class ItemNotFoundException extends NotFoundException {

    public ItemNotFoundException() {
        super();
    }

    public ItemNotFoundException(String message) {
        super(message);
    }

    public ItemNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ItemNotFoundException(Throwable cause) {
        super(cause);
    }
}