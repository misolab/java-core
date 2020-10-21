package com.misolab.core.exception;

import com.misolab.core.code.ApiStatus;

public class NotFoundException extends ApiException {
    public NotFoundException() {
        super(ApiStatus.NOT_FOUND, "");
    }

    public NotFoundException(String message) {
        super(ApiStatus.NOT_FOUND, message);
    }
}
