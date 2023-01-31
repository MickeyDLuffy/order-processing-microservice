package com.melita.ordertrackingapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponse {
    private CustomerDto customer;
    private InstallationDetail installationDetail;
    private List<Product> products;
    private double totalAmount;
    private String orderNumber;
    private OrderStatus status;
}
