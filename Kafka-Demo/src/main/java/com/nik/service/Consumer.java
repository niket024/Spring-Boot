package com.nik.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {
	private final Logger logger = LoggerFactory.getLogger(Consumer.class);

	@KafkaListener(topics = "bep.alltables.topic", groupId = "bep_slot5")
	public void consume(String message) {
		System.out.println("Received messges from topics: " + message);
		logger.info(String.format("$$ -> Consumed Message -> %s", message));
	}
}