package com.misolab.core.exception;


import com.misolab.core.code.ApiStatus;

public class InternalServerErrorException extends ApiException {
    public InternalServerErrorException() {
        super(ApiStatus.INTERNAL_SERVER_ERROR, "");
    }

    public InternalServerErrorException(String message) {
        super(ApiStatus.INTERNAL_SERVER_ERROR, message);
    }
}
