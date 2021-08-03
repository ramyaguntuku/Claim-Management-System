package com.cognizant.claimsmicroservice.model;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * 
 * This class contains test cases for the Claim model class which are written
 * using junit
 *
 */

@SpringBootTest
@RunWith(SpringRunner.class)
class ClaimTest {

	Claim claim = new Claim();


	/**
	 * 
	 * Testing Getters and setters
	 */
	@Test
	public void testPloicyId() {
		claim.setPolicyId(1);
		assertEquals(claim.getPolicyId(), 1);	
	}
	
	@Test
	void testMemberId()
	{
		claim.setMemberId(1);
		assertEquals(claim.getMemberId(), 1);
	}
	
	@Test
	void testClaimId() 
	{
		claim.setClaimId(1);
		assertEquals(claim.getClaimId(), 1);
	}
	
	@Test
	void testBenefitId()
	{
		claim.setBenefitId(202);
		assertEquals(claim.getBenefitId(), 202);
	}
	
	@Test
	void testAmountClaimed()
	{
		claim.setAmountClaimed(10000.0);
		assertEquals(claim.getAmountClaimed(), 10000.0);
	}
	
	@Test
	void testAmountSettled() 
	{
		claim.setAmountSettled(10000.0);
		assertEquals(claim.getAmountSettled(), 10000.0);
	}
	
	@Test
	void testClaimStatus()
	{
		claim.setClaimStatus("Pending Action");
		assertEquals(claim.getClaimStatus(), "Pending Action");
	}
	
	@Test
	void testDescription()
	{
		claim.setDescription("claim has been submitted! Please check after few days for confirmation");
		assertEquals(claim.getDescription(), "claim has been submitted! Please check after few days for confirmation");
	}
	
	@Test
	void testProviderId()
	{
	claim.setProviderId(1);
	assertEquals(claim.getProviderId(), 1);
	}
	
}
