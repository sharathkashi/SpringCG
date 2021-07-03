package com.exam.ms.controller;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.ms.dto.UserEmail;

@RestController
@RequestMapping("/getEmail")
public class UserEmailController {
	
@GetMapping("all/{id}")
public Optional<UserEmail> getEmail(@PathVariable("id") Integer userId)
{
	UserEmail ue=new UserEmail(userId,"sharthkumar@gmail.com");
	return Optional.of(ue);
}
}
