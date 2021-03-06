package com.rmi.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TestRunner implements CommandLineRunner {

    private final OrderService orderService;

    public TestRunner(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public void run(String... args) throws Exception {
        orderService.placeOrder(new Order("Mangoes", 100));
        System.out.println("Orders from the server :" + orderService.getOrder());
    }
}
