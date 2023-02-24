package com.springbootbackendvolunteering.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springbootbackendvolunteering.model.UserEntity;
import com.springbootbackendvolunteering.repository.UserEntityRepo;

@Service()
public class CustomUserDetailService implements UserDetailsService {

	@Autowired
	private UserEntityRepo userEntityRepo;

	@Override
	public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {

		UserEntity userEntity = userEntityRepo.findByUserEmail(userEmail);
		User u = new User(userEntity.getUserEmail(), userEntity.getPassword(), userEntity.getAuthorities());
		System.out.println(u.toString());
		return u;
	}

}
