package com.exam.boot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/")
public class MainController {
	@RequestMapping("/start")
	public String welcome() {
		return "Welcome to spring boot app";
	}

}
