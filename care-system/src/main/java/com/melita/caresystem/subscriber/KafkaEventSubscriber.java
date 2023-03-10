package com.melita.caresystem.subscriber;

import com.melita.caresystem.dto.OrderResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.kafka.annotation.KafkaListener;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaEventSubscriber {

    @KafkaListener(topics = "${com.melita.kafka.topic}")
    public void subscribe(OrderResponse orderResponse) {
        log.info("Publishing Order Request Failed: {}", orderResponse);
    }
}
