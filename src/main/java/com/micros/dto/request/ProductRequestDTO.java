package com.micros.dto.request;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class ProductRequestDTO {

    @NotBlank(message = "Name required")
    private String name;

    @NotBlank(message = "Category required")
    private String category;

    @NotNull(message = "Price required")
    @Positive(message = "Price must be positive")
    private Double price;

    @NotNull
    @Min(0)
    private Integer stockQuantity;

    @NotBlank
    private String supplierName;


}