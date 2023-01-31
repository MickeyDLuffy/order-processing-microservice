package com.melita.ordertrackingapi.restcontroller;

import com.melita.ordertrackingapi.dto.OrderRequest;
import com.melita.ordertrackingapi.dto.OrderResponse;
import com.melita.ordertrackingapi.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/orders")
public class OrderTrackingRestController {
    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CompletableFuture<OrderResponse> receiveOrderRequest(@RequestBody OrderRequest payload) {
        return orderService.createOrder(payload);
    }
}