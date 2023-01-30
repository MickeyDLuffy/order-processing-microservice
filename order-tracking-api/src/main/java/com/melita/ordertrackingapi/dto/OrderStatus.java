package com.melita.ordertrackingapi.dto;

import lombok.Getter;

@Getter
public enum OrderStatus {
    RECEIVED("received"),
    PROCESSED("PROCESSED"),
    SHIPPED("SHIPPED"),
    CANCELLED("CANCELLED");

    private final String status;
     OrderStatus(String status) {
        this.status = status;
    }
}
