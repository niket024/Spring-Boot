package com.nik.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Service
public final class ProducerService {
	private static final Logger logger = LoggerFactory.getLogger(ProducerService.class);

	private final KafkaTemplate<String, String> kafkaTemplate;
	private final String TOPIC = "kafkaTopic";

	public ProducerService(KafkaTemplate<String, String> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}

	public void sendMessage(String message) {
		logger.info(String.format("$$$$ => Producing message: %s", message));
		//ListenableFuture<SendResult> You can register a callback with the listener 
		// to receive the result of the send asynchronously
		ListenableFuture<SendResult<String, String>> future = this.kafkaTemplate.send(TOPIC, message);
		future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
			@Override
			public void onFailure(Throwable ex) {
				logger.info("Unable to send message=[ {} ] due to : {}", message, ex.getMessage());
			}

			public void onSuccess(SendResult<String, String> result) {
				logger.info("Sent message=[ {} ] with offset=[ {} ]", message, result.getRecordMetadata().offset());
			}

		});
	}
	public void sendMessage(String message, String topicName) {
		logger.info(String.format("$$$$ => Again Producing message : %s", message));
		//ListenableFuture<SendResult> You can register a callback with the listener 
		// to receive the result of the send asynchronously
		ListenableFuture<SendResult<String, String>> future = this.kafkaTemplate.send(topicName, message);
		future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
			@Override
			public void onFailure(Throwable ex) {
				logger.info("Unable to send message=[ {} ] due to : {}", message, ex.getMessage());
			}
			
			public void onSuccess(SendResult<String, String> result) {
				logger.info("Sent message=[ {} ] with offset=[ {} ]", message, result.getRecordMetadata().offset());
			}
			
		});
	}
}