package com.example.demo.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.jpa.model.User;
import com.example.demo.jpa.repository.UserRepository;

@RestController
@RequestMapping("/secure/test")
public class AdminController {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEnocder;
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@PostMapping("/admin/addUser")
	public String addUser(@RequestBody User user) {
		String password = user.getPassword();
		String encryptPassword = passwordEnocder.encode(password);
		user.setPassword(encryptPassword);
		userRepository.save(user);
		return "User added successfully";
	}
}
