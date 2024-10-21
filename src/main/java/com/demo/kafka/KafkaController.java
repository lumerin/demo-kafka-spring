package com.demo.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/kafka")
public class KafkaController {
    private final Producer kafkaProducer;

    public KafkaController(Producer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/send")
    public ResponseEntity<String> sendMessage(@RequestBody Order order) {
        kafkaProducer.sendMessage(order);
        return ResponseEntity.ok("Message sent to Kafka Topic");
    }
}
