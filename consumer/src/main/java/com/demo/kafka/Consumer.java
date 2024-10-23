package com.demo.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class Consumer {
    @KafkaListener(topics = "order-topic")
    public void listen(Order order) {
        log.info("Consuming message: {}", order);
    }
}
