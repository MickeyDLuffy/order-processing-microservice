package com.melita.orderfullfilmentsystem.subscriber;

import com.melita.orderfullfilmentsystem.dto.OrderResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaEventSubscriber {
    @KafkaListener(topics = "${com.melita.kafka.topic}")
    public void subscribe(OrderResponse orderResponse) {
        log.info("Publishing Order Request Failed: {}", orderResponse);
    }
}
