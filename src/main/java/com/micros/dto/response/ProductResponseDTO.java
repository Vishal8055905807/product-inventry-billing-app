package com.micros.dto.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data

public class ProductResponseDTO {

    private Long id;
    private String name;
    private String category;
    private Double price;
    private Integer stockQuantity;
    private String supplierName;
    private LocalDateTime createdAt;


}