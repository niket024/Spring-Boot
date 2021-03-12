package com.nik;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@Value("${welcome.message}")
	String welcome;
	
	@Value("${app.description}")
	String description;

	@RequestMapping("/hello")
	public String getHello() {
		System.out.println(description);
		return welcome;
	}
}
