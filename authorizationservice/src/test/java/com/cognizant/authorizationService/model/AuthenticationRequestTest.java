package com.cognizant.authorizationService.model;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

	@SpringBootTest
	@RunWith(SpringRunner.class)
	public class AuthenticationRequestTest {

		
		public AuthenticationRequest authenticationRequest;
		
		@BeforeEach
		public void setup() {
			authenticationRequest=new AuthenticationRequest();
			authenticationRequest.setUsername("admin");
			authenticationRequest.setPassword("admin");
			
		}
		
		@Test
		public void allArgumentConstructorTest() {
			AuthenticationRequest userLog =new AuthenticationRequest("admin","admin");
			assertEquals("admin",userLog.getUsername());
			assertEquals("admin",userLog.getPassword());
		}
		
		@Test
		public void noArgConstructorTest() {
			AuthenticationRequest userLog=new AuthenticationRequest();
			assertEquals(userLog,userLog);
		}
		@Test
		public void usernameTest() {
			assertEquals("admin", authenticationRequest.getUsername());
		}

		@Test
		public void passwordTest() {
			assertEquals("admin", authenticationRequest.getPassword());
		}
		
	}


