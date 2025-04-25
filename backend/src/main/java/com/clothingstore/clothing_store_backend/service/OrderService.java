package com.clothingstore.clothing_store_backend.service;

import com.clothingstore.clothing_store_backend.model.Order;
import com.clothingstore.clothing_store_backend.model.Product;
import com.clothingstore.clothing_store_backend.repository.OrderRepository;
import com.clothingstore.clothing_store_backend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    public Order createOrder(String userId, Order order) {
        order.setUserId(userId);
        double totalAmount = 0.0;
        for (Order.OrderItem item : order.getProducts()) {
            Optional<Product> product = productRepository.findById(item.getProductId());
            if (product.isEmpty()) {
                throw new IllegalArgumentException("Product not found with id: " + item.getProductId());
            }
            totalAmount += product.get().getPrice() * item.getQuantity();
        }
        order.setTotalAmount(totalAmount);
        order.setStatus("PENDING");
        return orderRepository.save(order);
    }

    public List<Order> getOrdersByUserId(String userId) {
        return orderRepository.findByUserId(userId);
    }

    public Optional<Order> getOrderById(String id, String userId) {
        Optional<Order> order = orderRepository.findById(id);
        if (order.isPresent() && !order.get().getUserId().equals(userId)) {
            throw new IllegalArgumentException("Order does not belong to user");
        }
        return order;
    }
}