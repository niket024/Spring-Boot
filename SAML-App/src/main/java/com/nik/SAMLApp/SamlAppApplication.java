package com.nik.SAMLApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@Controller
public class SamlAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SamlAppApplication.class, args);
	}

	@RequestMapping("/")
	public String index() {
		return "index";
	}
}