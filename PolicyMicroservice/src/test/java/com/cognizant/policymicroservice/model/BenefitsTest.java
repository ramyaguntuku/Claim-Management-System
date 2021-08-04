package com.cognizant.policymicroservice.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/*
 * Test Cases for Benefits class
 */
@SpringBootTest
@RunWith(SpringRunner.class)
class BenefitsTest {

	public Benefits benefits;
	
	/*
	 * test if benefits class is working or not
	 */
	@BeforeEach
	void setUp() {
		benefits=new Benefits();
		benefits.setBenefitId(201);
		benefits.setBenefitName("Free Monthly Health Checkup");
		
	}
	@Test
	public void AllArgConstTest() {
		Benefits benefits1 = new Benefits(201, "Free Monthly Health Checkup");
		assertEquals(201, benefits1.getBenefitId());
		assertEquals("Free Monthly Health Checkup",benefits1.getBenefitName());

	}
	
	@Test
	public void noArgsConstructorTest() {
		
		Benefits benefits1 = new Benefits();
		assertEquals(benefits1, benefits1);
	}
	@Test
	public void benefitIdTest() {
		assertEquals(201, benefits.getBenefitId());
	}

	@Test
	public void benefitNameTest() {
		assertEquals("Free Monthly Health Checkup", benefits.getBenefitName());
	}
	
	
}
