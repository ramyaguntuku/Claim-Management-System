package com.cognizant.claimsmicroservice.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * This class contains test cases for the ProviderPolicy model class which are
 * written using junit
 *
 */
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
class ProviderPolicyTest {

	ProviderPolicy providerPolicy = new ProviderPolicy(1,"City Hospital","MG Road",1,"Chennai");

	/**
	 * 
	 * Testing ProviderPolicy All Argument Constructor
	 */
	@Test
	public void testProviderAllArgsConstructor() {
		assertEquals(1, providerPolicy.getProviderId());
		assertEquals("Chennai", providerPolicy.getLocation());
		assertEquals("City Hospital",providerPolicy.getProviderName());
		assertEquals( "MG Road",providerPolicy.getProviderAddress());
		assertEquals( 1,providerPolicy.getPolicyId());
	}

	/**
	 * 
	 * Testing Getters and setters
	 */
	@Test
	public void testProviderId() 
	{
		providerPolicy.setProviderId(2);
		assertEquals(2,providerPolicy.getProviderId());
	}
	
	@Test
	void testLocation()
	{
		providerPolicy.setLocation("Nagpur");
		assertEquals( "Nagpur",providerPolicy.getLocation());
	}
	
	@Test
	void testProviderName()
	{
		providerPolicy.setProviderName("LIC");
		assertEquals( "LIC",providerPolicy.getProviderName());
	}
	
	@Test
	void testProviderAddress() 
	{
		providerPolicy.setProviderAddress("Chitnis Nagar");
		assertEquals( "Chitnis Nagar",providerPolicy.getProviderAddress());
	}
	
	@Test
	void testPolicyId()
	{
		providerPolicy.setPolicyId(1);
		assertEquals( 1,providerPolicy.getPolicyId());
	}
	
	/**
	 * 
	 * Testing ProviderPolicy toString() method
	 */
	@Test
	public void testToString() {
		log.debug("providers={}", providerPolicy);
		String s = providerPolicy.toString();
		assertEquals(providerPolicy.toString(), s);

	}

}
