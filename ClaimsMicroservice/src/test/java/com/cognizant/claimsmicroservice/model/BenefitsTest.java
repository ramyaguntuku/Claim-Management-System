package com.cognizant.claimsmicroservice.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * This class contains test cases for the Benefits model class which are written
 * using junit
 *
 */
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
class BenefitsTest {
    Benefits benefit=new Benefits(201,"Free Monthly Health Checkup");
    
	/**
	 * 
	 * Testing Benefits All Argument Constructor
	 */
	@Test
	public void testBenefitsAllArgsConstructor() {
		assertEquals(201, benefit.getBenefitId());
		assertEquals("Free Monthly Health Checkup", benefit.getBenefitName());

	}

	@Test
	public void testGetterSetters() {

		benefit.setBenefitId(202);
		benefit.setBenefitName("Cashless Medical Treatment");

		assertEquals(benefit.getBenefitId(), 202);
		assertEquals(benefit.getBenefitName(), "Cashless Medical Treatment");

	}
	
	/**
	 * Testing Benefits toString() method
	 */
	@Test
	public void testToString() {
		log.debug("benefit={}", benefit);
		String s = benefit.toString();
		assertEquals(benefit.toString(), s);

	}

}
