package com.workshop.bcmentorsddd.domain.payment;

import com.workshop.bcmentorsddd.money.Money;

import java.util.UUID;

public class PaymentLine {

    private final UUID id = UUID.randomUUID();
    private Money amount;
    private PaymentType paymentType;

    public PaymentLine(Money amount, PaymentType paymentType) {
        this.amount = amount;
        this.paymentType = paymentType;
    }

    public Money getAmount() {
        return amount;
    }
}

public enum PaymentType {
    CASH,
    CARD
}
