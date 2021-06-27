package com.nik.service;

import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.listener.adapter.ConsumerRecordMetadata;
import org.springframework.stereotype.Service;

@Service
public final class ConsumerService {
	private static final Logger logger = LoggerFactory.getLogger(ConsumerService.class);
	// @Autowired
	KafkaConsumer<String, String> kafkaConsumer;
	@Autowired
	private ProducerService producerService;

	// Kafka push
	@KafkaListener(topics = "kafkaTopic", groupId = "group_id")
	public void consume(String message, ConsumerRecordMetadata meta) {
		logger.info(String.format("$$$$ => Consumed message: %s", message));
		System.out.println("partition = " + meta.partition());
		System.out.println("Offset = " + meta.offset());
		System.out.println("Topic = " + meta.topic());
		System.out.println(meta.timestamp());
		producerService.sendMessage("Again sending " + message, "kafkaTopic1");
	}

	@KafkaListener(topics = "kafkaTopic1", groupId = "group_id")
	public void consume1(String message, ConsumerRecordMetadata meta) {
		logger.info(String.format("$$$$ => Consumed message: %s", message));
		System.out.println("partition = " + meta.partition());
		System.out.println("Offset = " + meta.offset());
		System.out.println("Topic = " + meta.topic());
		System.out.println(meta.timestamp());
	}

}
