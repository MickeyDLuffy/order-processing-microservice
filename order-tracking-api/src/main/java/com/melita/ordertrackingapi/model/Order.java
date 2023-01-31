package com.melita.ordertrackingapi.model;

import com.melita.ordertrackingapi.dto.CustomerDto;
import com.melita.ordertrackingapi.dto.InstallationDetail;
import com.melita.ordertrackingapi.dto.OrderStatus;
import com.melita.ordertrackingapi.dto.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "orders")
public class Order {
    private CustomerDto customer;
    private InstallationDetail installationDetail;
    private List<Product> products;
    private Double totalAmount;
    private String orderNumber;
    private OrderStatus status = OrderStatus.RECEIVED;
}
