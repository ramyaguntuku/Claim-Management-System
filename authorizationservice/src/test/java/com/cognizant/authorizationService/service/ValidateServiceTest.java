package com.cognizant.authorizationService.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cognizant.authorizationService.model.AuthenticationResponse;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ValidateServiceTest {

	@Mock
	JwtUtilService jwtUtilService;
	@InjectMocks
	private ValidateService validateService;
	
	@Test
	public void validateTest() {
		AuthenticationResponse response=validateService.validate("Bearer token");
		assertEquals("token",response.getJwtToken());
	}
}
