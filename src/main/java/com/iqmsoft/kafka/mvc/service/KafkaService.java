package com.iqmsoft.kafka.mvc.service;

public interface KafkaService {
    void sendInfo(String topic, Object obj);
    void getInfo(String topic);
}
