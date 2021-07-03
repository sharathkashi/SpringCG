package com.exam.ms.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.exam.ms.dto.User;
import com.exam.ms.dto.UserEmail;
import com.exam.ms.dto.UserName;

@RestController
@RequestMapping("/getDetails")
public class UserDetailsController {
	@Autowired
	private RestTemplate restTemplate;
	@GetMapping("user/{id}")
	public User getUser(@PathVariable("id") Integer userId)
	{
		UserEmail ue=restTemplate.getForObject("http://localhost:9092/getEmail/all/"+userId, UserEmail.class);
		UserName un=restTemplate.getForObject("http://localhost:9091/getName/all/"+userId, UserName.class);
		return new User(userId,ue.getEmail(),un.getCustomer_name());
	}

}
