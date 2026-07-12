package com.micros.service;


import com.micros.dto.request.ProductRequestDTO;
import com.micros.dto.response.ProductResponseDTO;
import com.micros.entity.Product;
import com.micros.exception.ProductNotFoundException;
import com.micros.mapper.ProductMapper;
import com.micros.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;


    @Override
    public ProductResponseDTO addProduct(ProductRequestDTO dto) {
        Product product = ProductMapper.toEntity(dto);
        Product saved = productRepository.save(product);

        return ProductMapper.toResponseDTO(saved);
    }

    @Override
    public Page<ProductResponseDTO> getAllProducts(int page, int size, String sortBy, String sortDir) {

        Pageable pageable = null;
        if (sortDir.contains("ASC")) {
            pageable=PageRequest.of(page, size, Sort.by(sortBy).ascending());
        } else {
            pageable= PageRequest.of(page, size, Sort.by(sortBy).descending());
        }
        Page<Product> all = productRepository.findAll(pageable);
        productRepository.findAll();

        return all.map(a -> ProductMapper.toResponseDTO(a));
    }

    @Override
    public ProductResponseDTO getById(Long productId) {
        Product product = productRepository.findById(productId).orElseThrow(() ->
                new ProductNotFoundException(
                        "Product not found with id: " + productId
                ));
        return ProductMapper.toResponseDTO(product);
    }

    @Override
    public ProductResponseDTO updateStock(Long productId, Integer stockQuantity) {
        Product product = productRepository.findById(productId).orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + productId));
        product.setStockQuantity(stockQuantity);
        Product saved = productRepository.save(product);

        return ProductMapper.toResponseDTO(saved);
    }

    @Override
    public void deleteProduct(Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() ->
                        new ProductNotFoundException(
                                "Product not found with id: " + productId
                        ));

        productRepository.delete(product);

    }

    @Override
    public Page<ProductResponseDTO> getLowStockProducts(Integer threshold, int page, int size, String sortBy) {

        Pageable pageable = PageRequest.of(
                page,
                size,
                Sort.by(sortBy)
        );

        Page<Product> byStockQuantityLessThanEqual = productRepository.findByStockQuantityLessThanEqual(threshold, pageable);
        return byStockQuantityLessThanEqual.map(e -> ProductMapper.toResponseDTO(e));
    }

}