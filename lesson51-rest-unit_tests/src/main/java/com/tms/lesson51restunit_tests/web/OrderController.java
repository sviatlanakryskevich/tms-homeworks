package com.tms.lesson51restunit_tests.web;

import com.tms.lesson51restunit_tests.domain.Order;
import com.tms.lesson51restunit_tests.domain.Status;
import com.tms.lesson51restunit_tests.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RequiredArgsConstructor
@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService service;
    @PostMapping
    public Order create(Order order){
        Order saved = service.create(order.getName());
        return saved;
    }
}
