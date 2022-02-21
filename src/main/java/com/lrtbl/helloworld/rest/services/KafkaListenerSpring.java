package com.lrtbl.helloworld.rest.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListenerSpring {

    private static final Logger logger = LoggerFactory.getLogger(KafkaListenerSpring.class);

    @KafkaListener(topics = "spring-topic", groupId = "consumerSpring")
    public void listen(String message) {
            logger.info("Mensaje recibido {}", message);
    }
}
