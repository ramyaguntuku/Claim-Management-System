package com.cognizant.authorizationService.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * This is the model class for AuthenticationResponse
 */ 
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationResponse {

	private String jwtToken;
	private Boolean valid;
	
	
	
	
}
