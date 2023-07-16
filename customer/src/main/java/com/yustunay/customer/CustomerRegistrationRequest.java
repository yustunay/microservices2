package com.yustunay.customer;

public record CustomerRegistrationRequest(
        String firstName,
        String lastName,
        String email) {
}
