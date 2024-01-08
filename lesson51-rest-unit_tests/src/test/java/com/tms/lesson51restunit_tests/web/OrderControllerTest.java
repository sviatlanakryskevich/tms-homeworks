package com.tms.lesson51restunit_tests.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tms.lesson51restunit_tests.domain.Order;
import com.tms.lesson51restunit_tests.domain.Status;
import com.tms.lesson51restunit_tests.service.OrderService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultHandler;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(OrderController.class)
class OrderControllerTest {
    @MockBean
    private OrderService orderService;
    @Autowired
    private MockMvc mockMvc;
    ObjectMapper mapper = new ObjectMapper();

    @Test
    public void testCreateOrder() throws Exception {
        Order order = new Order(1,"order1", Status.NEW);
        Mockito.when(orderService.create(Mockito.any()))
                .thenReturn(order);
        String json = mapper.writeValueAsString(order);
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/orders").content(json).contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        String contentAsString = mvcResult.getResponse().getContentAsString();
        Order order1 = mapper.readValue(contentAsString, Order.class);
        Assertions.assertThat(order1.getId()).isEqualTo(order.getId());
        Assertions.assertThat(order1.getName()).isEqualTo(order.getName());
        Assertions.assertThat(order1.getStatus()).isEqualTo(order.getStatus());
    }



}