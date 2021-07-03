package com.exam.ms.controller;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.ms.dto.UserName;



@RestController
@RequestMapping("/getName")
public class UserNameController {

	@GetMapping("/all/{id}")	
	public Optional<UserName> getName(@PathVariable("id") Integer userId) {
		UserName userName= new UserName(userId,"Sharu");
		return Optional.of(userName);
	}
	
}
