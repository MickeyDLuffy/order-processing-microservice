package com.melita.caresystem.restcontroller;

import com.melita.caresystem.dto.OrderRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/orders")
public class OrderTrackingRestController {

    //TODO: remove RestController once KafkaListener has been implemented

    @PostMapping
    public ResponseEntity<OrderRequest> receiveOrderRequest(@RequestBody OrderRequest payload) {
        return ResponseEntity.ok().body(payload);
    }
}
