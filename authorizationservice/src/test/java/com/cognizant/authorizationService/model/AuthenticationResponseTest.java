package com.cognizant.authorizationService.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
		assertEquals("Token", auth.getJwtToken());
		assertEquals(true,auth.getValid());

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
