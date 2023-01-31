package com.melita.ordertrackingapi.utils;

import com.melita.ordertrackingapi.dto.OrderRequest;
import com.melita.ordertrackingapi.model.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.function.SupplierUtils;

import java.util.function.Function;

@Component
@RequiredArgsConstructor
public class OrderConverter implements Function<OrderRequest, Order> {

    private final OrderNumberUtil orderNumberUtil;
    private final CalculateTotalAmount calculateTotalAmount;

    @Override
    public Order apply(OrderRequest orderRequest) {
        return Order.builder()
                .customer(orderRequest.getCustomer())
                .orderNumber(SupplierUtils.resolve(orderNumberUtil))
                .totalAmount(calculateTotalAmount.applyAsDouble(orderRequest.getProducts()))
                .installationDetail(orderRequest.getInstallationDetail())
                .products(orderRequest.getProducts())
                .build();
    }
}