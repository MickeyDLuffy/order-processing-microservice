package com.melita.ordertrackingapi.utils;

import com.melita.ordertrackingapi.dto.Product;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.ToDoubleFunction;

@Component
public class CalculateTotalAmount implements ToDoubleFunction<List<Product>> {
    @Override
    public double applyAsDouble(List<Product> products) {
        return products.stream()
                .filter(CalculateTotalAmount::hasPositivePrice)
                .mapToDouble(CalculateTotalAmount::sum)
                .sum();
    }

    private static boolean hasPositivePrice(Product product) {
        return product.getPrice() >= 0 && product.getQuantity() >= 0 && product.getProductPackage().getCost() >= 0;
    }
    private static Double sum(Product product) {
        return (product.getPrice() * product.getQuantity()) + product.getProductPackage().getCost();
    }
}
