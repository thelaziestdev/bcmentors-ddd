package com.workshop.bcmentorsddd.domain.payment;

import java.util.UUID;

//if we will extend JPA repository here we will have "Domain" Repository == "Infrastructure" Repository
public class PaymentRepository {

    public Payment save(Payment payment) {
        // save payment
        return payment;
    }

    public Payment getOrCreatePayment(UUID orderId) {
        Payment payment = findByOrderId(orderId);
        if (payment == null) {
            payment = new Payment(orderId);
        }
        return payment;
    }

    private Payment findByOrderId(UUID orderId) {
        // fetch payment by order id
        return null;
    }

}
