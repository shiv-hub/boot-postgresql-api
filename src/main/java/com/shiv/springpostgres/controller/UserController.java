package com.shiv.springpostgres.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shiv.springpostgres.model.User;
import com.shiv.springpostgres.repository.UserRepository;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserRepository userrepository;
	
	
	// for getting all users
	@GetMapping("/users")
	public List<User> getAllUser(){
		return this.userrepository.findAll();
	}
	
	//for posting a user
	@PostMapping("/user")
	public User saveUser(@RequestBody User user) {
		return this.userrepository.save(user);
	}
}
