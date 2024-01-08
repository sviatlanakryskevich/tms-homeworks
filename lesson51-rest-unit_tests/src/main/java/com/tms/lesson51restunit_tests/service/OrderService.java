package com.tms.lesson51restunit_tests.service;

import com.tms.lesson51restunit_tests.domain.Order;
import com.tms.lesson51restunit_tests.domain.Status;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
@RequiredArgsConstructor
@Service
public class OrderService {
    private final DataService dataService;
    public Order create(String name){
        Order order = Order.builder()
                .id(1)
                .name("order1")
                .status(Status.NEW)
                .build();
        if(name == null){
            return null;
        }
        Order save = dataService.save(order);
        return save;
    }

}
