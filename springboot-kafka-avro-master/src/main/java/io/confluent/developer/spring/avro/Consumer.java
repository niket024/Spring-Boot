package io.confluent.developer.spring.avro;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import io.confluent.developer.User;
import lombok.extern.apachecommons.CommonsLog;

@Service
@CommonsLog(topic = "Consumer Logger")
public class Consumer {
	private static Logger log = LoggerFactory.getLogger(Consumer.class);
	@Value("${topic.name}")
	private String topicName;

	@KafkaListener(topics = "mytopic", groupId = "group_id")
	public void consume(ConsumerRecord<String, User> record) {
		log.info(String.format("Consumed message -> %s", record.value()));
	}
}