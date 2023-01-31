package com.melita.ordertrackingapi.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.melita.ordertrackingapi.dto.CustomerDto;
import com.melita.ordertrackingapi.dto.InstallationDetail;
import com.melita.ordertrackingapi.dto.OrderRequest;
import com.melita.ordertrackingapi.dto.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OrderValidatorTest {

    OrderRequest orderRequest;
    @Mock
    ObjectMapper objectMapper;
    JsonNode expectedJsonNode;
    @InjectMocks
    private OrderValidator orderValidator;

    @BeforeEach
    void init() {
        var customer = CustomerDto.builder().address("Accra").firstname("mickey").lastname("Jasmine").build();
        orderRequest = OrderRequest.builder()
                .customer(customer)
                .products(List.of(Product.builder().description("we are here").build()))
                .installationDetail(InstallationDetail.builder().installationAddress("Dress Rosa").build())
                .build();
        try {
            expectedJsonNode = objectMapper.readTree("{\"address\":\"Accra\"}");
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    void testGetJsonNodeFromStringContent_Success() throws IOException {
        String customerJson = "{\"address\":\"Accra\"}";
        when(objectMapper.readTree(customerJson)).thenReturn(expectedJsonNode);
        JsonNode actualJsonNode = orderValidator.getJsonNodeFromStringContent(customerJson);
        assertEquals(expectedJsonNode, actualJsonNode);
    }

}