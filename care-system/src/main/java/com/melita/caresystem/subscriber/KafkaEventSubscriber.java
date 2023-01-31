package com.melita.caresystem.subscriber;

import com.melita.caresystem.dto.OrderRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class KafkaEventSubscriber {

    private void subscribe() {
        OrderRequest payload = new OrderRequest();
        log.info("Publishing Order Request Failed: {}", payload);
    }
}
