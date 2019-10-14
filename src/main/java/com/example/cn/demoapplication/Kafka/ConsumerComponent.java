package com.example.cn.demoapplication.Kafka;

import org.springframework.stereotype.Component;

@Component
public class ConsumerComponent {

    //@KafkaListener(topics = "testTopic")
    public void onMessage(Object message) {
        System.out.println(message);
    }
}
