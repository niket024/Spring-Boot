package com.nik;

import java.util.Map;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import com.nik.config.SomeBean;

@SpringBootApplication
public class KafkaProducerConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaProducerConsumerApplication.class, args);
	}

	@Bean
	public ConsumerFactory<?, ?> kafkaConsumerFactory(KafkaProperties properties, SomeBean someBean) {
		Map<String, Object> consumerProperties = properties.buildConsumerProperties();
		consumerProperties.put(ConsumerConfig.INTERCEPTOR_CLASSES_CONFIG, MyConsumerInterceptor.class.getName());
		consumerProperties.put("some.bean", someBean);
		return new DefaultKafkaConsumerFactory<>(consumerProperties);
	}

	@Bean
	public ProducerFactory<?, ?> kafkaProducerFactory(KafkaProperties properties, SomeBean someBean) {
		Map<String, Object> producerProperties = properties.buildProducerProperties();
		producerProperties.put(ProducerConfig.INTERCEPTOR_CLASSES_CONFIG, MyProducerInterceptor.class.getName());
		producerProperties.put("some.bean", someBean);
		DefaultKafkaProducerFactory<?, ?> factory = new DefaultKafkaProducerFactory<>(producerProperties);
		String transactionIdPrefix = properties.getProducer().getTransactionIdPrefix();
		if (transactionIdPrefix != null) {
			factory.setTransactionIdPrefix(transactionIdPrefix);
		}
		return factory;
	}

	@Bean
	public SomeBean someBean() {
		return new SomeBean();
	}

	@KafkaListener(id = "kgk897", topics = "kgh897")
	public void listen(String in) {
		System.out.println("Received " + in);
	}

	@Bean
	public ApplicationRunner runner(KafkaTemplate<String, String> template) {
		return args -> template.send("kgh897", "test");
	}

	@Bean
	public NewTopic kRequests() {
		return TopicBuilder.name("kgh897").partitions(1).replicas(1).build();
	}

}
