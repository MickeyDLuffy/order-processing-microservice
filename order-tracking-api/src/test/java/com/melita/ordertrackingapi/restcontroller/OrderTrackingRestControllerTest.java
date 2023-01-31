package com.melita.ordertrackingapi.restcontroller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.melita.ordertrackingapi.dto.*;
import com.melita.ordertrackingapi.service.OrderService;
import com.melita.ordertrackingapi.utils.JsonUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(OrderTrackingRestController.class)
class OrderTrackingRestControllerTest {
    OrderResponse orderResponse;
    OrderRequest orderRequest;
    @MockBean
    private OrderService orderService;


    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @BeforeEach
    void init() {
        objectMapper = new ObjectMapper();
        var customer = CustomerDto.builder().address("Accra").firstname("mickey").lastname("Jasmine").build();
        orderResponse = OrderResponse.builder()
                .customer(customer)
                .orderNumber("ORD-2023-11-12-2222")
                .build();

        orderRequest = OrderRequest.builder()
                .customer(customer)
                .products(List.of(Product.builder().description("we are here").build()))
                .installationDetail(InstallationDetail.builder().installationAddress("Dress Rosa").build())
                .build();
    }

    @Test
    void testReceiveOrderRequestWithSuccess() throws Exception {
        CompletableFuture<OrderResponse> future = CompletableFuture.completedFuture(orderResponse);
        when(orderService.createOrder(orderRequest))
                .thenReturn(future);
        mockMvc.perform(post("/api/v1/orders")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JsonUtil.stringify(orderRequest)))
                .andExpect(status().isCreated())
                .andReturn();

        OrderResponse order = future.get();
        assertEquals("ORD-2023-11-12-2222", order.getOrderNumber());
        assertEquals("mickey", order.getCustomer().getFirstname());
        verify(orderService, times(1)).createOrder(orderRequest);
    }
}