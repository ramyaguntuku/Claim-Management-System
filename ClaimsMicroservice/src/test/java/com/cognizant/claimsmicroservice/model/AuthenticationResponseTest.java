package com.cognizant.claimsmicroservice.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 
 * This class contains test cases for the AuthenticationResponse model class
 * which are written using junit
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class AuthenticationResponseTest {

 AuthenticationResponse authenticationResponse= new AuthenticationResponse();
	
	@Test
	void testIsValid() {
		authenticationResponse.setValid(true);
		assertEquals( true, authenticationResponse.getValid());
	}
	@Test
	void testJwtToken()
	{
		authenticationResponse.setJwtToken("dummy-token");
		assertEquals("dummy-token",authenticationResponse.getJwtToken());
	}
	
	
}
