package com.workshop.bcmentorsddd.domain.order;

import com.workshop.bcmentorsddd.money.Currency;
import com.workshop.bcmentorsddd.money.Money;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Order {

    private final UUID id = UUID.randomUUID();
    private Money amount = new Money(0, Currency.USD);
    private List<OrderedProduct> orderedProducts = new ArrayList<>();
    private boolean isPaid = false;
    private Money paidAmount = new Money(0, Currency.USD);

    public void addProduct(OrderedProduct product) {
        orderedProducts.add(product);
        amount = new Money(amount.amount() + product.unitPrice().amount() * product.quantity(), product.unitPrice().currency());
    }

    // if order is not paid fully don't mark it as paid
    public void pay(Money amount) {
        if (isPaid) {
            throw new IllegalStateException("Order is already paid");
        }
        paidAmount = new Money(paidAmount.amount() + amount.amount(), amount.currency());
        if (this.amount.amount() <= paidAmount.amount()) {
            isPaid = true;
        }
    }

    public Money getDueAmount() {
        return new Money(amount.amount() - paidAmount.amount(), amount.currency());
    }

    public UUID getId() {
        return id;
    }
}
