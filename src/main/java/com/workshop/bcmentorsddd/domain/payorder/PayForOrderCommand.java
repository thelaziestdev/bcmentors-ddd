package com.workshop.bcmentorsddd.domain.payorder;

import com.workshop.bcmentorsddd.domain.payment.PaymentType;
import com.workshop.bcmentorsddd.money.Money;

import java.util.UUID;

public record PayForOrderCommand(UUID orderId, Money amount, PaymentType paymentType) {
}
