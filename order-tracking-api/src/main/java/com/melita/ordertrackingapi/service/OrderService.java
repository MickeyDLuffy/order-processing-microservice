package com.melita.ordertrackingapi.service;

import com.melita.ordertrackingapi.dto.OrderRequest;
import com.melita.ordertrackingapi.dto.OrderResponse;

import java.util.concurrent.CompletableFuture;

public interface OrderService {
    CompletableFuture<OrderResponse> createOrder(OrderRequest order);
}
