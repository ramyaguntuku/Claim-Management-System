package com.cognizant.authorizationService.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import com.cognizant.authorizationService.model.Error;


@SpringBootTest
@RunWith(SpringRunner.class)
public class ErrorTest {
	

	Error error;
	LocalDateTime localDateTime= LocalDateTime.now();
	@BeforeEach
	public void setUp() {
		error=new Error();
		error.setStatus(HttpStatus.OK);
		error.setTimestamp(localDateTime);
		error.setMessage("msg");

	}

	@Test
	public void allArgumentConstructorTest() {
		Error error1 = new Error(HttpStatus.OK, LocalDateTime.now(), "msg");
		assertEquals(HttpStatus.OK, error1.getStatus());
		assertEquals(LocalDateTime.now(), error1.getTimestamp());
		assertEquals("msg", error1.getMessage());	
	}

	@Test
	public void noArgumentConstructorTest() {
		Error error1 = new Error();
		assertEquals(error1, error1);
	}
	@Test
	public void StatusTest() {
		assertEquals(HttpStatus.OK, error.getStatus());
	}

	@Test
	public void TimestampTest() {
		assertEquals(localDateTime, error.getTimestamp());
	}

	@Test
	public void messageTest() {
		assertEquals("msg", error.getMessage());
	}



}
