package com.clothingstore.clothing_store_backend.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "orders")
@Data
@Builder
public class Order {

    @Id
    private String id;

    private String userId;

    @NotEmpty(message = "Products list cannot be empty")
    private List<OrderItem> products;

    @Positive(message = "Total amount must be positive")
    private Double totalAmount;

    @Builder.Default
    private String status = "PENDING"; // e.g., PENDING, COMPLETED, CANCELLED

    @Data
    @Builder
    public static class OrderItem {
        @NotNull(message = "Product ID is required")
        private String productId;

        @NotNull(message = "Quantity is required")
        @Positive(message = "Quantity must be positive")
        private Integer quantity;
    }
}