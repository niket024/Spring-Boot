package com.nik;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nik.service.ConsumerService;
import com.nik.service.ProducerService;

@RestController
@RequestMapping("/kafka")
public final class KafkaController {
	private final ProducerService producerService;
	private final ConsumerService consumerService;

	public KafkaController(ProducerService producerService, ConsumerService consumerService) {
		this.producerService = producerService;
		this.consumerService = consumerService;
	}

	@GetMapping(value = "/publish")
	public String sendMessageToKafkaTopic(@RequestParam String message) {
		producerService.sendMessage(message);
		return "Msg sent successfully";
	}

	@GetMapping(value = "/get")
	public String receiveMessageFromKafkaTopic() {
		consumerService.getMsg();
		return "Msg received successfully";
	}
}
