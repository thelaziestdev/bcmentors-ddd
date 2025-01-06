package com.workshop.bcmentorsddd.domain.payorder;

import com.workshop.bcmentorsddd.domain.order.OrderRepository;
import com.workshop.bcmentorsddd.domain.payment.PaymentRepository;
import com.workshop.bcmentorsddd.infra.EventSender;

// Application layer service
public class PayForOrderCommandHandler {

    private final OrderRepository orderRepository;
    private final PaymentRepository paymentRepository;
    private final PaymentService paymentService;
    private final EventSender eventSender;

    public PayForOrderCommandHandler(OrderRepository orderRepository, PaymentRepository paymentRepository, PaymentService paymentService, EventSender eventSender) {
        this.orderRepository = orderRepository;
        this.paymentRepository = paymentRepository;
        this.paymentService = paymentService;
        this.eventSender = eventSender;
    }

    //@Transactional
    void handle(PayForOrderCommand command) {
        //persistence
        var order = orderRepository.findById(command.orderId());
        //persistence
        var payment = paymentRepository.getOrCreatePayment(command.orderId());
        // business logic
        paymentService.payForOrder(order, payment, command.amount(), command.paymentType());

        // persistence
        orderRepository.save(order);
        // persistence
        paymentRepository.save(payment);

        // infrastructure
        eventSender.send(new OrderPaidEvent(order.getId(), command.amount()));
    }

}
