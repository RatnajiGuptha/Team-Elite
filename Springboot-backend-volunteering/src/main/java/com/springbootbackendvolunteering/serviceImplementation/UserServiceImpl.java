package com.springbootbackendvolunteering.serviceImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootbackendvolunteering.model.Role;
import com.springbootbackendvolunteering.model.User;
import com.springbootbackendvolunteering.repository.RoleRepo;
import com.springbootbackendvolunteering.repository.UserRepo;
import com.springbootbackendvolunteering.service.UserService;


@Service
public class UserServiceImpl implements UserService{

	
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	RoleRepo roleRepo;
	
	@Override
	public void registerUser(User user, Role role) throws Exception {
//		User u =userRepo.findByUserName(user.getUserName());
//		if(u!=null) {
//			throw new Exception("User already exits");
//		}
//		else if(user.getUserName()=="" || user.getUserName()==null) {
//			throw new Exception("Enter a valid username");
//		}
			userRepo.save(user);
			roleRepo.save(role);
	}

	@Override
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}

	@Override
	public void deleteUser(int id) {
		userRepo.deleteById(id);
	}




	
	
	
	
	
	

}
