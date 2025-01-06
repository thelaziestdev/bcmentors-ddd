package com.workshop.bcmentorsddd.domain.order;

import com.workshop.bcmentorsddd.money.Money;

import java.util.UUID;

public record OrderedProduct(UUID productId, int quantity, Money unitPrice) {
}
