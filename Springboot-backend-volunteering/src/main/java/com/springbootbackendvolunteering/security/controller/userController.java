package com.springbootbackendvolunteering.security.controller;

import java.util.List;
import java.util.Scanner;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springbootbackendvolunteering.model.UserEntity;
import com.springbootbackendvolunteering.repository.UserEntityRepo;
import com.springbootbackendvolunteering.service.EmailOtpService;

@RestController
public class userController {

	Scanner sc = new Scanner(System.in);

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	UserEntityRepo userDtRepo;

	@Autowired
	EmailOtpService emailOtpService;

	@GetMapping("/get")
	public String home() {
		return "welcome";
	}

	@GetMapping("/getUserDetails")
	public List<UserEntity> userdata() {
		return userDtRepo.findAll();
	}

	@PostMapping("/addUser")
	public ResponseEntity<String> addUser(@RequestBody UserEntity user, HttpSession session) {
		String role = user.getRole();
		UserEntity u = userDtRepo.findByUserEmail(user.getUserEmail());
		if (u != null) {
			return ResponseEntity.badRequest().body("User already exists");
		}
		if (u == null) {
			String otp = emailOtpService.generateOtp();
			session.setAttribute("otp", otp);
			emailOtpService.sendOtp(user.getUserEmail(), otp);
			String enteredOtp = sc.nextLine();
			if (emailOtpService.validateOtp(otp, enteredOtp)) {
				user.setPassword(passwordEncoder.encode(user.getPassword()));
				user.setRole("USER");
				userDtRepo.save(user);
				return ResponseEntity.ok("user Added");
			}
		}
		return ResponseEntity.badRequest().body("Request otp");

	}

}
