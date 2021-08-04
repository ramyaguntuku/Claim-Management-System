package com.cognizant.authorizationService.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest
@RunWith(SpringRunner.class)
public class MyUserTest {
	

	MyUser myUser;
	
	@BeforeEach
	public void setUp() {
		myUser=new MyUser();
		myUser.setMemberid(1);
		myUser.setUsername("suman");
		myUser.setPassword("abc");

	}

	@Test
	public void allArgumentConstructorTest() {
		MyUser user = new MyUser(1, "admin", "admin");
		assertEquals(1, user.getMemberid());
		assertEquals("admin", user.getUsername());
		assertEquals("admin", user.getPassword());	
	}

	@Test
	public void noArgumentConstructorTest() {
		MyUser user = new MyUser();
		assertEquals(user, user);
	}
	@Test
	public void memberIdTest() {
		assertEquals(1, myUser.getMemberid());
	}

	@Test
	public void usernameTest() {
		assertEquals("suman", myUser.getUsername());
	}

	@Test
	public void passwordTest() {
		assertEquals("abc", myUser.getPassword());
	}

	@Test
	public void equalsMethodTest() {
		boolean equals = myUser.equals(myUser);
		assertTrue(equals);
	}

}
