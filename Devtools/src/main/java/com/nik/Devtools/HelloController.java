package com.nik.Devtools;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	@RequestMapping("/")
	public String hello() {
		String msg = "Hello from Devtool test again again";
		return msg;
	}
}
