
    package com.hostelcheck.backend.service;

    import com.hostelcheck.backend.entity.Payment;
    import com.hostelcheck.backend.repository.PaymentRepository;

    import org.springframework.context.annotation.Profile;
import org.springframework.beans.factory.annotation.Value;
    import org.springframework.http.MediaType;
    import org.springframework.stereotype.Service;
    import org.springframework.web.client.RestClient;

    import java.util.LinkedHashMap;
    import java.util.Map;

    @Profile("payments")
@Service
    public class PaymentService {

        private final PaymentRepository paymentRepository;
        private final RestClient restClient;

        @Value("${interswitch.merchant-code}")
        private String merchantCode;

        @Value("${interswitch.pay-item-id}")
        private String payItemId;

        @Value("${interswitch.currency}")
        private String currency;

        @Value("${interswitch.paybill-url}")
        private String paybillUrl;

        @Value("${interswitch.verification-url}")
        private String verificationUrl;

        @Value("${app.payment-return-url}")
        private String returnUrl;

        public PaymentService(PaymentRepository paymentRepository) {
            this.paymentRepository = paymentRepository;
            this.restClient = RestClient.create();
        }

        // CREATE INTERSWITCH PAYMENT LINK
        public Map<String, Object> initiatePayment(
                Long amountKobo,
                String customerEmail) {

            if (amountKobo == null || amountKobo <= 0) {
                throw new IllegalArgumentException("Invalid payment amount");
            }

            if (customerEmail == null ||
                    !customerEmail.matches("^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$")) {
                throw new IllegalArgumentException("Invalid customer email");
            }

            Map<String, Object> request = new LinkedHashMap<>();

            request.put("merchantCode", merchantCode);
            request.put("payableCode", payItemId);
            request.put("amount", String.valueOf(amountKobo));
            request.put("redirectUrl", returnUrl);
            request.put("customerId", customerEmail);
            request.put("currencyCode", currency);
            request.put("customerEmail", customerEmail);

            Map<String, Object> result = restClient.post()
                    .uri(paybillUrl)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(request)
                    .retrieve()
                    .body(Map.class);

            if (result == null ||
                    result.get("paymentUrl") == null ||
                    result.get("reference") == null) {
                throw new IllegalStateException(
                        "Interswitch did not return a payment URL and reference");
            }

            String reference = result.get("reference").toString();
            String paymentUrl = result.get("paymentUrl").toString();

            if (paymentRepository.existsByTransactionReference(reference)) {
                throw new IllegalStateException(
                        "Duplicate Interswitch transaction reference");
            }

            Payment payment = new Payment();
            payment.setTransactionReference(reference);
            payment.setAmountKobo(amountKobo);
            payment.setCustomerEmail(customerEmail);
            payment.setStatus("PENDING");

            paymentRepository.save(payment);

            Map<String, Object> response = new LinkedHashMap<>();

            response.put("transactionReference", reference);
            response.put("paymentUrl", paymentUrl);
            response.put("status", "PENDING");

            return response;
        }

        // VERIFICATION WILL BE COMPLETED AGAINST
        // THE DOCUMENTED INTERSWITCH AUTHENTICATED API.
        public Map<String, Object> verifyPayment(String reference) {
            throw new UnsupportedOperationException(
                    "Payment verification is not configured yet");
        }
    }
