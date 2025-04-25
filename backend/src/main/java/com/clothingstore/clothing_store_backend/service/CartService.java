package com.clothingstore.clothing_store_backend.service;

import com.clothingstore.clothing_store_backend.model.User;
import com.clothingstore.clothing_store_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartService {

    @Autowired
    private UserRepository userRepository;

    public User addToCart(String userId, String productId) {
        Optional<User> userOpt = userRepository.findById(userId);
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            List<String> cart = user.getCart();
            if (cart == null) {
                cart = new ArrayList<>();
            }
            if (!cart.contains(productId)) {
                cart.add(productId);
            }
            user.setCart(cart);
            return userRepository.save(user);
        }
        throw new RuntimeException("User not found");
    }

    public User removeFromCart(String userId, String productId) {
        Optional<User> userOpt = userRepository.findById(userId);
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            List<String> cart = user.getCart();
            if (cart != null) {
                cart.remove(productId);
                user.setCart(cart);
                return userRepository.save(user);
            }
        }
        throw new RuntimeException("User not found");
    }

    public List<String> getCart(String userId) {
        Optional<User> userOpt = userRepository.findById(userId);
        if (userOpt.isPresent()) {
            return userOpt.get().getCart() != null ? userOpt.get().getCart() : new ArrayList<>();
        }
        throw new RuntimeException("User not found");
    }
}