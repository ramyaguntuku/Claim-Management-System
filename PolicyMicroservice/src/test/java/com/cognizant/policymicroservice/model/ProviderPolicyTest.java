package com.cognizant.policymicroservice.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/*
 * Test Cases for ProviderPolicy class 
 */
@SpringBootTest
@RunWith(SpringRunner.class)
class ProviderPolicyTest {

	public ProviderPolicy providerPolicy;

	/*
	 * test the ProviderPolicy class allArgsConstructor
	 */
	@BeforeEach
	void setUp() {
		providerPolicy = new ProviderPolicy();
		providerPolicy.setProviderId(1);
		providerPolicy.setProviderName("LIC");
		providerPolicy.setProviderAddress("MG Road");
		providerPolicy.setPolicyId(1);
		providerPolicy.setLocation("Kolkata");	
	}

	@Test
	public void allArgsConstructorTest() {

		ProviderPolicy providerPolicy1 = new ProviderPolicy(1,"LIC","MG Road",1,"Kolkata");
		assertEquals(1,providerPolicy1.getProviderId());
		assertEquals("LIC",providerPolicy1.getProviderName());
		assertEquals("MG Road",providerPolicy1.getProviderAddress());
		assertEquals(1,providerPolicy1.getPolicyId());
		assertEquals("Kolkata",providerPolicy1.getLocation());
	}

	/*
	 * test the ProviderPolicyclass NoArgsConstructor
	 */
	@Test
	public void NoArgsConstructorTest() {

		ProviderPolicy providerPolicy1 = new ProviderPolicy();
		assertEquals(providerPolicy1, providerPolicy1);
	}
	@Test
	public void policyTest() {
		
		assertEquals(1,providerPolicy.getProviderId());
		assertEquals("LIC",providerPolicy.getProviderName());
		assertEquals("MG Road",providerPolicy.getProviderAddress());
		assertEquals(1,providerPolicy.getPolicyId());
		assertEquals("Kolkata",providerPolicy.getLocation());
		
		
	}

	
}
