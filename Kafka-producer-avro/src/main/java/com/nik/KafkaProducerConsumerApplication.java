package com.nik;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nik.service.Sender;

import example.avro.User;

@SpringBootApplication
public class KafkaProducerConsumerApplication implements ApplicationRunner {
	@Autowired
	private Sender producerService;

	public static void main(String[] args) {
		SpringApplication.run(KafkaProducerConsumerApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		User user = User.newBuilder().setName("John Doe").setFavoriteColor("green")
		        .setFavoriteNumber(null).build();
		producerService.send(user);
	}

}
