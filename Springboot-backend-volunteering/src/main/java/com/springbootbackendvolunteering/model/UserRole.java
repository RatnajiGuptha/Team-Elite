package com.springbootbackendvolunteering.model;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRole {

	private int userRoleId;
	
	private User user;
	
	private Role role;

}
