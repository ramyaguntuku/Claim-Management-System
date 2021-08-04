package com.cognizant.authorizationService.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * This is the model class for username, password, token
 */ 
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "myuser")
public class MyUser {

	@Id
	@Column(name = "memberid")
	private int memberid;

	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;

	
}
