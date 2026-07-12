package com.micros.service;

import com.micros.dto.request.ProductRequestDTO;
import com.micros.dto.response.ProductResponseDTO;
import org.springframework.data.domain.Page;

public interface ProductService {

    ProductResponseDTO addProduct(ProductRequestDTO dto);

    Page<ProductResponseDTO> getAllProducts(
            int page,
            int size,
            String sortBy,String sortDir
    );

    ProductResponseDTO getById(Long productId);

    ProductResponseDTO updateStock(
            Long productId,
            Integer stockQuantity
    );

    void deleteProduct(Long productId);

    Page<ProductResponseDTO> getLowStockProducts(
            Integer threshold,
            int page,
            int size,
            String sortBy
    );
}
