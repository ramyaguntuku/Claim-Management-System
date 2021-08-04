package com.cognizant.policymicroservice.model;



import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/*
 * Test Cases for Policy class
 */
@SpringBootTest
@RunWith(SpringRunner.class)
class PolictyTest {


	public Policy policy;

	@BeforeEach
	void setUp() {
		policy=new Policy();
		policy.setBenefitId(201);
		policy.setCapAmountBenefits(150000.00);
		policy.setPolicyId(1);
		policy.setPolicyNumber(101);
		policy.setPremium(5000.0);
		policy.setTenure(25);
	}
	
	/*
	 * test the Policy class is working properly or not
	 */
	@Test
	public void policyTest() {
		
		assertEquals(1,policy.getPolicyId());
		assertEquals(101,policy.getPolicyNumber());
		assertEquals(201,policy.getBenefitId());
		assertEquals(5000.0,policy.getPremium());
		assertEquals(25,policy.getTenure());
		assertEquals(150000.00,policy.getCapAmountBenefits());
		
		
	}
	
	/*
	 * test the Policy class NoArgsConstructor
	 */
	@Test
	public void noArgsConstructorTest() {
		Policy policy1=new Policy();
		assertEquals(policy1,policy1);
	}
	@Test
	public void allArgsConstructorTest()  {
		
		Policy policy1 = new Policy(1, 101, 201, 5000.0,25, 150000.00);
		assertEquals(1,policy1.getPolicyId());
		assertEquals(101,policy1.getPolicyNumber());
		assertEquals(201,policy1.getBenefitId());
		assertEquals(5000.0,policy1.getPremium());
		assertEquals(25,policy1.getTenure());
		assertEquals(150000.00,policy1.getCapAmountBenefits());
		
	}
	
}
