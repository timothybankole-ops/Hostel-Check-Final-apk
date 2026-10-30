
package com.hostelcheck.backend.controller;

import com.hostelcheck.backend.dto.PaymentRequest;
import com.hostelcheck.backend.service.PaymentService;

import jakarta.validation.Valid;

import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Profile("payments")
@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    // Initiate a payment
    @PostMapping("/initiate")
    public ResponseEntity<Map<String, Object>> initiatePayment(
            @Valid @RequestBody PaymentRequest request) {

        Map<String, Object> response =
                paymentService.initiatePayment(
                        request.amountKobo(),
                        request.customerEmail()
                );

        return ResponseEntity.ok(response);
    }

    // Verify a payment
    @GetMapping("/verify/{reference}")
    public ResponseEntity<Map<String, Object>> verifyPayment(
            @PathVariable String reference) {

        Map<String, Object> response =
                paymentService.verifyPayment(reference);

        return ResponseEntity.ok(response);
    }
}
