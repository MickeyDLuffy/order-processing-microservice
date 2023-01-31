package com.melita.ordertrackingapi.utils;

import com.melita.ordertrackingapi.dto.OrderResponse;
import com.melita.ordertrackingapi.model.Order;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class OrderToOrderResponse implements Function<Order, OrderResponse> {

    @Override
    public OrderResponse apply(Order order) {
        return OrderResponse.builder()
                .customer(order.getCustomer())
                .orderNumber(order.getOrderNumber())
                .installationDetail(order.getInstallationDetail())
                .status(order.getStatus())
                .products(order.getProducts())
                .totalAmount(order.getTotalAmount())
                .build();
    }
}
