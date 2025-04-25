package com.clothingstore.clothing_store_backend.repository;

import com.clothingstore.clothing_store_backend.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}