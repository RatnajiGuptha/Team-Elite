package com.eventVoluntering.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.eventVoluntering.models.UserDetails;
import com.eventVoluntering.repository.UserDeatailsRepository;

@RestController
public class UserController {

	@Autowired
	UserDeatailsRepository userdtRepo;

	private final PasswordEncoder passwordEncoder;

	public UserController(PasswordEncoder passwordEncoder) {
		super();
		this.passwordEncoder = passwordEncoder;
	}

	@PostMapping("/addUser")
	public ResponseEntity<?> addUser(@Valid @RequestBody UserDetails user) {
		UserDetails userEmail = userdtRepo.findByUserEmail(user.getUserEmail());
		if (userEmail == null) {
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			UserDetails saveUser = userdtRepo.save(user);
			return ResponseEntity.ok(saveUser);
		} else {
			return ResponseEntity.badRequest().body("User with email " + user.getUserEmail() + " already exists");
		}

	}
}
