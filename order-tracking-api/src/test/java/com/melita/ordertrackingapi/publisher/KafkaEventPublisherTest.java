package com.melita.ordertrackingapi.publisher;

import com.melita.ordertrackingapi.config.ApplicationConfiguration;
import com.melita.ordertrackingapi.dto.CustomerDto;
import com.melita.ordertrackingapi.dto.OrderResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.kafka.core.KafkaTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
 class KafkaEventPublisherTest {
    OrderResponse orderResponse;
    String topic;

    @Mock
    private ApplicationConfiguration applicationConfiguration;

    @Mock
    private KafkaTemplate<String, OrderResponse> kafkaTemplate;

    @InjectMocks
    private KafkaEventPublisher kafkaEventPublisher;

    @BeforeEach
    void init() {
        topic = "orders";
        var customer = CustomerDto.builder().address("Accra").firstname("mickey").lastname("Jasmine").build();
        orderResponse = OrderResponse.builder()
                .customer(customer)
                .orderNumber("ORD-2023-11-12-2222")
                .build();
    }

    @Test
    void testPublishOrderEvent_callsKafkaTemplateOnceWithResponse() {
        ApplicationConfiguration.KafkaConfigs kafkaConfigs = new ApplicationConfiguration.KafkaConfigs();
        kafkaConfigs.setTopic(topic);

        when(applicationConfiguration.getKafka()).thenReturn(kafkaConfigs);
        kafkaEventPublisher.publishOrderEvent(orderResponse);
        verify(kafkaTemplate, times(1)).sendDefault(kafkaConfigs.getTopic(), orderResponse);
    }

    @Test
    void testPublishOrderEventToCorrectTopic() {
        ApplicationConfiguration applicationConfiguration = new ApplicationConfiguration();
        applicationConfiguration.getKafka().setTopic(topic);

        KafkaTemplate<String, OrderResponse> kafkaTemplate = mock(KafkaTemplate.class);
        KafkaEventPublisher kafkaEventPublisher = new KafkaEventPublisher(applicationConfiguration, kafkaTemplate);

        kafkaEventPublisher.publishOrderEvent(orderResponse);

        ArgumentCaptor<String> topicCaptor = ArgumentCaptor.forClass(String.class);
        ArgumentCaptor<OrderResponse> payloadCaptor = ArgumentCaptor.forClass(OrderResponse.class);
        verify(kafkaTemplate).sendDefault(topicCaptor.capture(), payloadCaptor.capture());
        assertEquals(topic, topicCaptor.getValue());
    }

}
