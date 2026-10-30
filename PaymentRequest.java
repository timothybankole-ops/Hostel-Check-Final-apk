
package com.hostelcheck.backend.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record PaymentRequest(

        @NotNull
        @Positive
        Long amountKobo,

        @NotNull
        @Email
        String customerEmail

) {}
