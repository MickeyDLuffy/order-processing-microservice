package com.melita.ordertrackingapi.publisher;

import com.melita.ordertrackingapi.config.ApplicationConfiguration;
import com.melita.ordertrackingapi.dto.OrderResponse;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public record KafkaEventPublisher(ApplicationConfiguration applicationConfiguration,
                                  KafkaTemplate<String, OrderResponse> kafkaTemplate) {

    public OrderResponse publishOrderEvent(OrderResponse payload) {
        kafkaTemplate.sendDefault(applicationConfiguration.getKafka().getTopic(), payload);
        return payload;
    }
}