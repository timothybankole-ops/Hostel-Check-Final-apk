
package com.hostelcheck.backend.repository;

import com.hostelcheck.backend.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

    Optional<Payment> findByTransactionReference(String transactionReference);

    boolean existsByTransactionReference(String transactionReference);
}
