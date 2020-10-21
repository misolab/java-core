package com.misolab.core.exception;

import com.misolab.core.code.ApiStatus;

public class ApiException extends RuntimeException {
    private int code;

    public ApiException(int code, String message) {
        super(message);
        this.code = code;
    }

    public ApiException(ApiStatus status, String message) {
        super(message);
        this.code = status.getCode();
    }

    public ApiException(String message) {
        super(message);
        this.code = ApiStatus.SUCCESS.getCode();
    }

    public int getCode() {
        return this.code;
    }
}
