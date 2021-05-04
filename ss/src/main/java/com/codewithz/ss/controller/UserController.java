package com.codewithz.ss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.codewithz.ss.model.User;
import com.codewithz.ss.repository.UserRepository;

@RestController
public class UserController 
{
	@Autowired
	UserRepository repository;
	
	@PostMapping("/saveUser")
	public String saveUser(@RequestBody User u)
	{
		BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
		String encodedPawword=encoder.encode(u.getPassword());
		u.setPassword(encodedPawword);
		
		repository.save(u);
		
		return "SUCCESS";
	}

}
