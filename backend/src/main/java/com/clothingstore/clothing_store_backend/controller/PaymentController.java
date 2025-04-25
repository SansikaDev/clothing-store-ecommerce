package com.clothingstore.clothing_store_backend.controller;

import com.stripe.Stripe;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    @Value("${stripe.api.key}")
    private String stripeApiKey;

    @PostMapping("/create-payment-intent")
    public ResponseEntity<String> createPaymentIntent(@RequestBody PaymentRequest request) throws Exception {
        Stripe.apiKey = stripeApiKey;

        PaymentIntentCreateParams params = PaymentIntentCreateParams.builder()
            .setAmount((long) (request.getAmount() * 100)) // Amount in cents
            .setCurrency("usd")
            .addPaymentMethodType("card")
            .build();

        PaymentIntent paymentIntent = PaymentIntent.create(params);
        return new ResponseEntity<>(paymentIntent.getClientSecret(), HttpStatus.OK);
    }
}

class PaymentRequest {
    private double amount;

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}