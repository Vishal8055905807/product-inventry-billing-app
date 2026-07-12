package com.micros.dto.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ApiResponse <T>{

    private boolean success;
    private String message;
    private int statusCode;
    private LocalDateTime timestamp;
    private T data;
}
