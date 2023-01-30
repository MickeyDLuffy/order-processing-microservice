package com.melita.ordertrackingapi.restcontroller;

import com.melita.ordertrackingapi.dto.OrderRequest;
import com.melita.ordertrackingapi.dto.OrderResponse;
import com.melita.ordertrackingapi.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/orders")
public class OrderTrackingRestController {

    private final OrderService orderService;

    @PostMapping
    public CompletableFuture<OrderResponse> receiveOrderRequest(@RequestBody OrderRequest payload) {
        return orderService.createOrder(payload);
    }
}