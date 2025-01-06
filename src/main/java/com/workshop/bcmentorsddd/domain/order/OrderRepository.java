package com.workshop.bcmentorsddd.domain.order;

import java.util.UUID;

//if we will extend JPA repository here we will have "Domain" Repository == "Infrastructure" Repository
public class OrderRepository {

    //save or update
    public Order save(Order order) {
        // save order
        return order;
    }

    public Order findById(UUID orderId) {
        // fetch order
        return null;
    }

}
