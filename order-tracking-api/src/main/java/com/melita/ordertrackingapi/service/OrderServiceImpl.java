package com.melita.ordertrackingapi.service;

import com.melita.ordertrackingapi.dto.OrderRequest;
import com.melita.ordertrackingapi.dto.OrderResponse;
import com.melita.ordertrackingapi.exception.OrderPublishException;
import com.melita.ordertrackingapi.publisher.KafkaEventPublisher;
import com.melita.ordertrackingapi.repository.OrderRepository;
import com.melita.ordertrackingapi.utils.OrderConverter;
import com.melita.ordertrackingapi.utils.OrderToOrderResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class OrderServiceImpl implements OrderService {

    private final OrderConverter orderConverter;
    private final OrderToOrderResponse orderToOrderResponse;
    private final OrderRepository orderRepository;
    private final KafkaEventPublisher kafkaEventPublisher;

    private final KafkaEventPublisher eventPublisher;


    @Override
    public CompletableFuture<OrderResponse> createOrder(OrderRequest order) {
        return CompletableFuture
                .supplyAsync(() -> orderConverter.apply(order), Executors.newFixedThreadPool(5))
                .thenApply(orderRepository::save)
                .thenApply(orderToOrderResponse)
                .exceptionally(ex -> {
                    throw new OrderPublishException("Publishing was unsuccessful" + ex.getCause(), ex);
                });
    }
}