package com.workshop.bcmentorsddd.money;

public record Money(int amount, Currency currency) {
}

public enum Currency {
    USD,
    EUR,
    GBP
}
