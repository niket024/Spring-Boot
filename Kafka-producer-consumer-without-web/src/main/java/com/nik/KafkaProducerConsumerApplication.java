package com.nik;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nik.service.ProducerService;

@SpringBootApplication
public class KafkaProducerConsumerApplication implements ApplicationRunner {
	@Autowired
	private ProducerService producerService;

	public static void main(String[] args) {
		SpringApplication.run(KafkaProducerConsumerApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		producerService.sendMessage("I am sending at starting of application");

	}
}
