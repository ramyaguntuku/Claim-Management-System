package com.cognizant.policymicroservice.model;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/*
 * Test Cases for AuthenticationResponse
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class AuthenticationResponseTest {

	@Mock
	public AuthenticationResponse authenticationResponse;

	@BeforeEach
	void setUp() {
		authenticationResponse=new AuthenticationResponse();
		authenticationResponse.setJwtToken("Token");
		authenticationResponse.setValid(true);
		
	}
	
	@Test
	public void AllArgConstTest() {
		AuthenticationResponse auth = new AuthenticationResponse("Token", true);
		assertEquals(authenticationResponse.getValid(), auth.getValid());
		assertEquals(authenticationResponse.getJwtToken(),auth.getJwtToken());

	}
	
	@Test
	public void noArgsConstructorTest() {
		
		authenticationResponse = new AuthenticationResponse();
		assertEquals(authenticationResponse, authenticationResponse);
	}
	@Test
	public void jwtTokenTest() {
		assertEquals("Token", authenticationResponse.getJwtToken());
	}

	@Test
	public void validTest() {
		assertEquals(true, authenticationResponse.getValid());
	}
	
}