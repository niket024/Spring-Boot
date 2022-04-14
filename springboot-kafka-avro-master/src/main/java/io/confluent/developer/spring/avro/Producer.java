package io.confluent.developer.spring.avro;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import io.confluent.developer.User;
import lombok.extern.apachecommons.CommonsLog;

@Service
@CommonsLog(topic = "Producer Logger")
public class Producer {
	private static Logger log = LoggerFactory.getLogger(Producer.class);

	@Value("${topic.name}")
	private String TOPIC;

	private final KafkaTemplate<String, User> kafkaTemplate;

	@Autowired
	public Producer(KafkaTemplate<String, User> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}

	void sendMessage(User user) {
		this.kafkaTemplate.send(this.TOPIC, user.getName(), user);
		log.info(String.format("Produced user -> %s", user));
	}
}
