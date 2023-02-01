package com.melita.ordertrackingapi.utils;

import com.melita.ordertrackingapi.dto.Package;
import com.melita.ordertrackingapi.dto.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CalculateTotalAmountTest {
    Product product1;
    @BeforeEach
    void init() {
         product1 = Product.builder()
                .name("TV")
                .description("for fun")
                .quantity(5)
                .price(10)
                .productPackage(Package.builder().cost(10.0).name("Internet").build())
                .build();
    }

    @Test
    void testApplyAsDouble() {


        List<Product> products = List.of(product1);

        CalculateTotalAmount calculateTotalAmount = new CalculateTotalAmount();
        double result = calculateTotalAmount.applyAsDouble(products);
        assertEquals(60.0, result);
    }

    @Test
    void testApplyAsDouble_returnsZeroIfEmptyList() {
        List<Product> products = List.of();

        CalculateTotalAmount calculateTotalAmount = new CalculateTotalAmount();
        double result = calculateTotalAmount.applyAsDouble(products);
        assertEquals(0.0, result);
    }

    @Test
    void testApplyAsDouble_shouldIgnoreNumbers() {
        Product product2 = Product.builder()
                .name("TV")
                .description("for fun")
                .quantity(5)
                .price(-10)
                .productPackage(Package.builder().cost(10.0).name("Internet").build())
                .build();
        List<Product> products = List.of(product2);

        CalculateTotalAmount calculateTotalAmount = new CalculateTotalAmount();
        double result = calculateTotalAmount.applyAsDouble(products);
//        If price or quantity is negative, ignore that product
        assertEquals(0.0, result);
    }
}