package com.springbootbackendvolunteering.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	
	@Id
	private int empId;
	
	private String userName;
	
	private String emailId;
	
	private String firstName;
	
	private String lastName;
	
	private String password;
	
	private String phoneNumber;
	
	private String gender;
	
	private String BU;	
	
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JsonIgnore
	private Role role;
	
	

}
