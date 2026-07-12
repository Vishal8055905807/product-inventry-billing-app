package com.micros.controller;

import com.micros.dto.request.ProductRequestDTO;
import com.micros.dto.response.ApiResponse;
import com.micros.dto.response.ProductResponseDTO;
import com.micros.service.ProductService;
import com.micros.util.ResponseUtil;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    @Autowired
    private ProductService productService;


    @PostMapping("/add")
    public ResponseEntity<ApiResponse<ProductResponseDTO>> addProduct(@Valid @RequestBody ProductRequestDTO productRequestDTO) {

        ProductResponseDTO productResponseDTO = productService.addProduct(productRequestDTO);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(
                        ResponseUtil.success("Product created successfully", 201, productResponseDTO));

    }

    @GetMapping("/view")
    public ResponseEntity<ApiResponse<List<ProductResponseDTO>>> getAllProducts(@RequestParam(required = false, defaultValue = "1") Integer pageNo,
                                                                                @RequestParam(required = false,defaultValue = "5") Integer pageSize,
                                                                                @RequestParam(required = false,defaultValue = "name") String sortby,
                                                                                @RequestParam(required = false,defaultValue = "ASC") String sortDir) {

        Page<ProductResponseDTO> allProducts = productService.getAllProducts(pageNo - 1, pageSize, sortby, sortDir);

        return ResponseEntity.ok().body(
                ResponseUtil.success("success", 200, allProducts.getContent())
        );

    }


}
