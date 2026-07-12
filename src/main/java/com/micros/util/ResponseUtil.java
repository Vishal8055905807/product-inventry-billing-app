package com.micros.util;

import com.micros.dto.response.ApiResponse;

import java.time.LocalDateTime;

public class ResponseUtil {

    public static <T> ApiResponse<T> success(String message, int statusCode, T data) {

        ApiResponse<T> response = new ApiResponse<>();
        response.setSuccess(true);
        response.setMessage(message);
        response.setStatusCode(statusCode);
        response.setTimestamp(LocalDateTime.now());
        response.setData(data);

        return response;
    }
}
