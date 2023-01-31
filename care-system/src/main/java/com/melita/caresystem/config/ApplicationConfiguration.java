package com.melita.caresystem.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties("com.melita")
public class ApplicationConfiguration {

    @NestedConfigurationProperty
    private final KafkaConfigs kafka = new KafkaConfigs();

    @Getter
    @Setter
    public static class KafkaConfigs {
        private String topic;
    }
}
