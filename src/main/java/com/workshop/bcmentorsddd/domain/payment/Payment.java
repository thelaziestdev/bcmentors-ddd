package com.workshop.bcmentorsddd.domain.payment;

import com.workshop.bcmentorsddd.money.Currency;
import com.workshop.bcmentorsddd.money.Money;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Payment {

    public Payment(UUID orderId) {
        this.orderId = orderId;
    }

    private final UUID orderId;
    private Money amount = new Money(0, Currency.USD);
    private List<PaymentLine> paymentLines = new ArrayList<>();

    public void addPaymentLine(PaymentLine paymentLine) {
        paymentLines.add(paymentLine);
        // TODO: solve issue with different currencies
        amount = new Money(amount.amount() + paymentLine.getAmount().amount(), paymentLine.getAmount().currency());
    }
}


