package com.clothingstore.clothing_store_backend.repository;

import com.clothingstore.clothing_store_backend.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface OrderRepository extends MongoRepository<Order, String> {
    List<Order> findByUserId(String userId);
}