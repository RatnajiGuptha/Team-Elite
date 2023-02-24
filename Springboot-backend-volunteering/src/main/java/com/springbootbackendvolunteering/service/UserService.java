package com.springbootbackendvolunteering.service;

import java.util.List;

import com.springbootbackendvolunteering.model.Role;
import com.springbootbackendvolunteering.model.User;

public interface UserService {

	
	public void registerUser(User user,Role role) throws Exception;
	
	public List<User> getAllUsers();
	
	public void deleteUser(int id);

	
	
	
}
