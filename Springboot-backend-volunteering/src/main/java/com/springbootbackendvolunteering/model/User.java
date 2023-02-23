package com.springbootbackendvolunteering.model;

import javax.persistence.Entity;
import javax.persistence.Id;

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
	
	private int firstName;
	
	private int lastName;
	
	private String emailId;
	
	private String phoneNumber;
	
	private String gender;
	
	private String BU;	
	

}
