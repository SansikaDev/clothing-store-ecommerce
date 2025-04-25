package com.clothingstore.clothing_store_backend.controller;

import com.clothingstore.clothing_store_backend.model.User;
import com.clothingstore.clothing_store_backend.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/add/{productId}")
    public ResponseEntity<User> addToCart(@PathVariable String productId, @AuthenticationPrincipal UserDetails userDetails) {
        User updatedUser = cartService.addToCart(userDetails.getUsername(), productId);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @DeleteMapping("/remove/{productId}")
    public ResponseEntity<User> removeFromCart(@PathVariable String productId, @AuthenticationPrincipal UserDetails userDetails) {
        User updatedUser = cartService.removeFromCart(userDetails.getUsername(), productId);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<String>> getCart(@AuthenticationPrincipal UserDetails userDetails) {
        List<String> cart = cartService.getCart(userDetails.getUsername());
        return new ResponseEntity<>(cart, HttpStatus.OK);
    }
}