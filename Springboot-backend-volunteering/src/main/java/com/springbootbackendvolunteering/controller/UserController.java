package com.springbootbackendvolunteering.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootbackendvolunteering.model.Role;
import com.springbootbackendvolunteering.model.User;
import com.springbootbackendvolunteering.serviceImplementation.UserServiceImpl;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserServiceImpl userServiceImpl;

	
	@PostMapping("/login")
	public void registerUser(@RequestBody User user) throws Exception {
		Role role =new Role();
		role.setRoleId(50);
		role.setRoleName("Normal");
		user.setRole(role);
		userServiceImpl.registerUser(user, role);

	}

	@GetMapping("/getusers")
	public List<User> getUserDetails() {
		return userServiceImpl.getAllUsers();
	}

	@DeleteMapping("/delete/{id}")
	public void deleteUser(@PathVariable("id") int id) {
		userServiceImpl.deleteUser(id);
	}

}
