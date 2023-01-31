package com.melita.ordertrackingapi.config;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@WebMvcTest(ApplicationConfiguration.class)
class ApplicationConfigurationTest {

    @Test
    void testApplicationConfiguration() {
        ApplicationConfiguration config = new ApplicationConfiguration();
        config.getKafka().setTopic("orders");
        assertEquals("orders", config.getKafka().getTopic());
    }
}