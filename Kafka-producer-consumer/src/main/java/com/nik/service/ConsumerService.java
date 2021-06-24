package com.nik.service;

import java.time.Duration;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public final class ConsumerService {
	private static final Logger logger = LoggerFactory.getLogger(ConsumerService.class);
	// @Autowired
	KafkaConsumer<String, String> kafkaConsumer;

	// Kafka push
	@KafkaListener(topics = "kafkaTopic", groupId = "group_id")
	public void consume(String message) {
		logger.info(String.format("$$$$ => Consumed message: %s", message));
	}

	/*
	 * //Kafk poll public void getMsg() { ConsumerRecords<String, String> records;
	 * while(true) { records = kafkaConsumer.poll(Duration.ofMillis(1000));
	 * for(ConsumerRecord<String, String> record: records) {
	 * logger.info(String.format("$$$$ => Consumed message: %s", record.value())); }
	 * } }
	 */

}
