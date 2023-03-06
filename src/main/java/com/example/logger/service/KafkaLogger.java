package com.example.logger.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class KafkaLogger {

  @KafkaListener(topics = "${spring.kafka.topic}", groupId = "${spring.kafka.groupId}")
  public void processMessage(ConsumerRecord<String, String> consumerRecord) {
    String value = consumerRecord.value();
    log.info("Received value: " + value);
  }
}
