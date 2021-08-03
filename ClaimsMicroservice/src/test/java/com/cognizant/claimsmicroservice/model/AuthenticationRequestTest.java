package com.cognizant.claimsmicroservice.model;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 
 * This class contains test cases for the AuthenticationRequest model class
 * which are written using junit
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class AuthenticationRequestTest {
	AuthenticationRequest authenticationRequest=new AuthenticationRequest();
	
	@Test
	void testUsername() {
		authenticationRequest.setUsername("admin");
		assertEquals( "admin", authenticationRequest.getUsername());
	}

	@Test
	void testPassword() {
		authenticationRequest.setPassword("admin");
		assertEquals( "admin", authenticationRequest.getPassword());
	}

}
