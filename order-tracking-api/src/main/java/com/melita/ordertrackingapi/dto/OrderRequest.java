package com.melita.ordertrackingapi.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class OrderRequest {
    private CustomerDto customer;
    private InstallationDetail installationDetail;
    private List<Product> products;
    private double totalAmount;
}
