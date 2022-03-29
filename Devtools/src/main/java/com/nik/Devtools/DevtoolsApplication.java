package com.nik.Devtools;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //@configuration +@ComponentScan +@EnableAutoConfiguration
public class DevtoolsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DevtoolsApplication.class, args);
	}
}
