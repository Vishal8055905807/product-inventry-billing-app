package com.micros.mapper;

import com.micros.dto.request.ProductRequestDTO;
import com.micros.dto.response.ProductResponseDTO;
import com.micros.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public static Product toEntity(ProductRequestDTO dto){
        Product product=new Product();
        product.setName(dto.getName());
        product.setCategory(dto.getCategory());
        product.setPrice(dto.getPrice());
        product.setStockQuantity(dto.getStockQuantity());
        product.setSupplierName(dto.getSupplierName());
        return product;
    }

    public static ProductResponseDTO toResponseDTO(Product product) {
        ProductResponseDTO dto = new ProductResponseDTO();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setCategory(product.getCategory());
        dto.setPrice(product.getPrice());
        dto.setStockQuantity(product.getStockQuantity());
        dto.setSupplierName(product.getSupplierName());
        dto.setCreatedAt(product.getCreatedAt());
        return dto;
    }
}
