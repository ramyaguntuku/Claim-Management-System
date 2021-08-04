package com.cognizant.authorizationService;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;



@SpringBootTest
@RunWith(SpringRunner.class)
class JwtAuthenticationApplicationTests {
	
	@Test
	public void applicationContextLoaded() {
	}

	@Test
	public void applicationContextTest() {
		JwtAuthenticationApplication.main(new String[] {});
	}

}
