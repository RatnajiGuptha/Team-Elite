package com.eventVoluntering.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eventVoluntering.models.UserDetails;

public interface UserDeatailsRepository extends JpaRepository<UserDetails, Long> {

	UserDetails findByUserEmail(String userEmail);

}
