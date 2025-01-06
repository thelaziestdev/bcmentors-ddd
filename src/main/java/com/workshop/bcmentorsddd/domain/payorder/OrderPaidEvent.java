package com.workshop.bcmentorsddd.domain.payorder;

import com.workshop.bcmentorsddd.infra.Event;
import com.workshop.bcmentorsddd.money.Money;

import java.util.UUID;

public record OrderPaidEvent(UUID orderId, Money amount) implements Event {
}
