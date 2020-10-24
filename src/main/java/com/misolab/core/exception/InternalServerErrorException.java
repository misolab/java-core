package com.misolab.core.exception;


import com.misolab.core.code.ApiStatus;

/**
 * @author ock
 */
public class InternalServerErrorException extends ApiException {
    /**
     *
     */
    public InternalServerErrorException() {
        super(ApiStatus.INTERNAL_SERVER_ERROR, "");
    }

    /**
     * @param message
     */
    public InternalServerErrorException(String message) {
        super(ApiStatus.INTERNAL_SERVER_ERROR, message);
    }
}
