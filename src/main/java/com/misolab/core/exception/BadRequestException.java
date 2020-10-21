package com.misolab.core.exception;

import com.misolab.core.code.ApiStatus;

public class BadRequestException extends ApiException {
    public BadRequestException() {
        super(ApiStatus.BAD_REQUEST, "");
    }

    public BadRequestException(String message) {
        super(ApiStatus.BAD_REQUEST, message);
    }
}
