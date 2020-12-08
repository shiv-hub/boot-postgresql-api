package com.shiv.springpostgres.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shiv.springpostgres.exception.ResourceNotFoundException;
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
	
	@GetMapping("/users/{id}")
	public ResponseEntity<User> getUserById(@PathVariable(value = "id") Long uid)
			throws ResourceNotFoundException {
		User user = this.userrepository.findById(uid)
				.orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + uid));
		return ResponseEntity.ok().body(user);
	}
	
	
	//Find by Email
	@GetMapping("/users/email/{email}")
	public ResponseEntity<User> getUserById(@PathVariable(value = "email") String email)
			throws ResourceNotFoundException {
		User user = this.userrepository.findByEmail(email)
				.orElseThrow(() -> new ResourceNotFoundException("User not found for this email :: " + email));
		return ResponseEntity.ok().body(user);
	}
	
	//for posting a user
	@PostMapping("/user")
	public User saveUser(@RequestBody User user) {
		return this.userrepository.save(user);
	}
	
	//for editing user
	@PutMapping("/users/{id}")
	public ResponseEntity<User> updateUser(@PathVariable(value = "id") Long uid,
			@Validated @RequestBody User userDetails) throws ResourceNotFoundException {
		User user = this.userrepository.findById(uid)
				.orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + uid));

		user.setEmail(userDetails.getEmail());
		user.setPwd(userDetails.getPwd());
		final User updatedUser = this.userrepository.save(user);
		return ResponseEntity.ok(updatedUser);
	}
	
	// for Deleting User
	@DeleteMapping("/users/{id}")
	public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Long uid)
			throws ResourceNotFoundException {
		User user = this.userrepository.findById(uid)
				.orElseThrow(() -> new ResourceNotFoundException("user not found for this id :: " + uid));

		this.userrepository.delete(user);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
