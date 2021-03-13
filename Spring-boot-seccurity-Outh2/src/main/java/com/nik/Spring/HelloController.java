package com.nik.Spring;

import java.security.Principal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	@GetMapping("/user")
	public Principal user(Principal principal) {
		return principal;
	}
}
