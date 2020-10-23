package com.misolab.core.vo;

import com.misolab.core.exception.ApiException;

import java.util.HashMap;
import java.util.Map;

public class ApiResponse {

    Map<String, Object> data;
    Map<String, Object> error;

    public ApiResponse() {
    }

    public Map<String, Object> getData() {
        return data;
    }

    public Map<String, Object> getError() {
        return error;
    }

    public ApiResponse(Map<String, Object> data) {
        this.data = data;
    }

    public static ApiResponse of(Map<String, Object> data) {
        return new ApiResponse(data);
    }

    public static ApiResponse of(String key, Object value) {
        return new ApiResponse().add(key, value);
    }

    public static ApiResponse error(ApiException exception) {
        return new ApiResponse().error(exception.getCode(), exception.getMessage());
    }

    public ApiResponse add(String key, Object value) {
        if (data == null) {
            data = new HashMap<>();
        }
        data.put(key, value);
        return this;
    }

    public ApiResponse error(int code, String message) {
        if (error == null) {
            error = new HashMap<>();
        }
        error.put("code", code);
        error.put("message", message);
        return this;
    }
}
