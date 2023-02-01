package com.melita.ordertrackingapi.utils;

import com.melita.ordertrackingapi.dto.*;
import com.melita.ordertrackingapi.model.Order;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderToOrderResponseTest {
    @Test
    void testConversionOfOrderToOrderResponse() {
        OrderToOrderResponse mapper = new OrderToOrderResponse();
        Order order = Order.builder()
                .customer(CustomerDto.builder().firstname("mickey").lastname("Jesus").build())
                .orderNumber("ORD-2022-01-01-1234")
                .installationDetail(InstallationDetail.builder().installationAddress("Ghana").build())
                .status(OrderStatus.RECEIVED)
                .products(List.of(
                        Product.builder().name("Product 1").price(100.0).build(),
                        Product.builder().name("Product 2").price(200.0).build()
                ))
                .totalAmount(300.0)
                .build();

        OrderResponse response = mapper.apply(order);

        assertEquals(order.getCustomer().getFirstname(), response.getCustomer().getFirstname());
        assertEquals(order.getOrderNumber(), response.getOrderNumber());
        assertEquals(order.getInstallationDetail().getInstallationAddress(), response.getInstallationDetail().getInstallationAddress());
        assertEquals(order.getStatus(), response.getStatus());
        assertEquals(order.getProducts(), response.getProducts());
        assertEquals(order.getTotalAmount(), response.getTotalAmount());
    }
}