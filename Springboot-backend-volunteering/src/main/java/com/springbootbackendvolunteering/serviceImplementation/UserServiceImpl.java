package com.springbootbackendvolunteering.serviceImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootbackendvolunteering.model.User;
import com.springbootbackendvolunteering.repository.UserRepo;
import com.springbootbackendvolunteering.service.UserService;


@Service
public class UserServiceImpl implements UserService{

	
	@Autowired
	UserRepo userRepo;
	
	
	public User registerUser(User user) {
		// TODO Auto-generated method stub
		return userRepo.save(user);
	}


	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}
	
	
	
	
	

}
