package com.micros.repository;

import com.micros.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {

    Page<Product> findByStockQuantityLessThanEqual(
            Integer threshold,
            Pageable pageable
    );
}
