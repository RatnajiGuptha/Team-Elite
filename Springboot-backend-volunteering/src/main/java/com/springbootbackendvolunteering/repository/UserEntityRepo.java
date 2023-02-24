package com.springbootbackendvolunteering.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootbackendvolunteering.model.UserEntity;

public interface UserEntityRepo extends JpaRepository<UserEntity, Long> {

	UserEntity findByUserEmail(String userEmail);

}
