package com.melita.ordertrackingapi.exception;


import org.springframework.kafka.KafkaException;

public class OrderPublishException extends KafkaException {
    public OrderPublishException(String message, Throwable ex) {
        super(message);
    }
}