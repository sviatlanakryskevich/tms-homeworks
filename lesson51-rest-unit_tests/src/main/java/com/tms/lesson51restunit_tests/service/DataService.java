package com.tms.lesson51restunit_tests.service;

import com.tms.lesson51restunit_tests.domain.Order;
import org.springframework.stereotype.Service;

@Service
public class DataService {
    public Order save(Order order){
        throw new RuntimeException();
    }
}
