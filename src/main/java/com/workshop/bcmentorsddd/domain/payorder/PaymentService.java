package com.workshop.bcmentorsddd.domain.payorder;

import com.workshop.bcmentorsddd.domain.order.Order;
import com.workshop.bcmentorsddd.domain.payment.Payment;
import com.workshop.bcmentorsddd.domain.payment.PaymentLine;
import com.workshop.bcmentorsddd.domain.payment.PaymentType;
import com.workshop.bcmentorsddd.money.Money;

public class PaymentService {

    void payForOrder(Order order, Payment payment, Money amount, PaymentType paymentType) {
        payment.addPaymentLine(new PaymentLine(amount, paymentType));
        order.pay(amount);
    }

}
