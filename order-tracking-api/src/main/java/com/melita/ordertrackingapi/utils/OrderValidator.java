package com.melita.ordertrackingapi.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.melita.ordertrackingapi.dto.OrderRequest;
import com.melita.ordertrackingapi.exception.RequestValidationException;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.ValidationResult;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;

@Component
public record OrderValidator(JsonSchema jsonSchema, ObjectMapper objectMapper) {

    public void validatePayload(String orderJson) {
        JsonNode orderRequestJsonNode = getJsonNodeFromStringContent(orderJson);
        validate(orderRequestJsonNode);
    }
    
    public void validatePayload(OrderRequest order) {
        try {
            String orderJson = objectMapper.writeValueAsString(order);
            JsonNode orderRequestJsonNode = getJsonNodeFromStringContent(orderJson);
            validate(orderRequestJsonNode);
        } catch (JsonProcessingException e) {
            throw new RequestValidationException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    private void validate(JsonNode orderRequestJsonNode) {
        ValidationResult validationResult = jsonSchema.validateAndCollect(orderRequestJsonNode);

        final var validationMessages = validationResult.getValidationMessages();

        if (!validationMessages.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, validationMessages.toString());
        }
    }

    private JsonNode getJsonNodeFromStringContent(String content) {
        try {
            return objectMapper.readTree(content);
        } catch (IOException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
}