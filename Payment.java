
package com.hostelcheck.backend.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(
    name = "payments",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = "transactionReference")
    }
)
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String transactionReference;

    @Column(nullable = false)
    private Long amountKobo;

    @Column(nullable = false)
    private String customerEmail;

    @Column(nullable = false)
    private String status = "PENDING";

    private String paymentReference;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = createdAt;
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

    public Payment() {}

    public Long getId() {
        return id;
    }

    public String getTransactionReference() {
        return transactionReference;
    }

    public void setTransactionReference(String reference) {
        this.transactionReference = reference;
    }

    public Long getAmountKobo() {
        return amountKobo;
    }

    public void setAmountKobo(Long amountKobo) {
        this.amountKobo = amountKobo;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPaymentReference() {
        return paymentReference;
    }

    public void setPaymentReference(String paymentReference) {
        this.paymentReference = paymentReference;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}
