package com.softkali.foodkali.product.repository;


import com.softkali.foodkali.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,Long> {

    Optional<Product> findByProductId(String productId);
    Optional<List<Product>> findByLocation(String location);
    Optional<List<Product>> findByProductPhoneNumber(String productPhoneNumber);

}
