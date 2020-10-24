package com.misolab.core.exception;

import com.misolab.core.code.ApiStatus;

/**
 * @author ock
 */
public class NotFoundException extends ApiException {
    /**
     *
     */
    public NotFoundException() {
        super(ApiStatus.NOT_FOUND, "");
    }

    /**
     * @param message
     */
    public NotFoundException(String message) {
        super(ApiStatus.NOT_FOUND, message);
    }
}
