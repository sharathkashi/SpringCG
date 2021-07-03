package com.exam.boot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
	@GetMapping("/")
	public String welcome() {
		return "Hello Buddy";
	}

}
