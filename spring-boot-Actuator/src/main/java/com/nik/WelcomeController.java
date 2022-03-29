package com.nik;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {
	private static Logger logger = Logger.getLogger(WelcomeController.class);

	@RequestMapping("/index")
	public String welcome(Map<String, Object> model) {
		return "Hello";
	}
	
	
}