package com.springbootbackendvolunteering.controller.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springbootbackendvolunteering.security.CustomUserDetailService;
import com.springbootbackendvolunteering.security.JwtUtilTokenHelper;
import com.springbootbackendvolunteering.security.model.JwtRequest;
import com.springbootbackendvolunteering.security.model.JwtResponse;

@RestController
public class AuthController {

	@Autowired
	private CustomUserDetailService customUserDetailService;

	@Autowired
	private JwtUtilTokenHelper jwtUtilTokenHelper;

	@Autowired
	private AuthenticationManager authenticationManager;

	@PostMapping("/login")
	public ResponseEntity<JwtResponse> createToken(@RequestBody JwtRequest jwtRequest) throws Exception {
		try {
			this.authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(jwtRequest.getUserEmail(), jwtRequest.getPassword()));
		} catch (UsernameNotFoundException e) {
//			e.printStackTrace();
			throw new Exception("User Not Found Exception");
		} catch (BadCredentialsException e) {
//			e.printStackTrace();
			throw new Exception("Bad Credential");
		}

		UserDetails userDetails = this.customUserDetailService.loadUserByUsername(jwtRequest.getUserEmail());
		String token = this.jwtUtilTokenHelper.generateToken(userDetails);
		System.err.println(token);
		return ResponseEntity.ok(new JwtResponse(token));
	}

}
