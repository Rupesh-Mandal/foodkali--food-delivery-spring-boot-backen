package com.softkali.foodkali.order.repository;

import com.softkali.foodkali.order.model.OrderModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<OrderModel, Long> {

    Optional<List<OrderModel>> findBySellerId(String sellerId);
    Optional<List<OrderModel>> findByUserId(String userId);
}
