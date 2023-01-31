package com.melita.ordertrackingapi.service;

import com.melita.ordertrackingapi.dto.OrderRequest;
import com.melita.ordertrackingapi.dto.OrderResponse;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public interface OrderService {
    CompletableFuture<OrderResponse> createOrder(OrderRequest order);
}
