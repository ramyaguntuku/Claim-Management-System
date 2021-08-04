package com.cognizant.membermicroservice.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 
 * This class contains test cases for the MemberPolicy model class which are
 * written using junit
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class MemberPolicyTest {

	@Mock
	private MemberPolicy memberPolicy;

	/**
	 * 
	 * Testing MemberPolicy is not null
	 */

	@Test
	@DisplayName("Checking if MemberPolicy class is loading or not.")
	void memberPolicyIsLoadedOrNot() {
		assertThat(memberPolicy).isNotNull();
	}

	/**
	 * 
	 * Testing MemberPolicy Constructor
	 */

	@DisplayName("Checking if MemberPolicy class is responding correctly or not.")
	@Test
	void testingMemberPolicy() {
		memberPolicy = new MemberPolicy(1, "Abhishek", 3, "2020-07-01", 9, "Amravati", 4, "Medibuddy");
		memberPolicy.setMemberId(3);
		memberPolicy.setMemberName("Abhi");
		memberPolicy.setPolicyId(2);
		memberPolicy.setSubscriptionDate("2020-06-26");
		memberPolicy.setLocationId(3);
		memberPolicy.setLocationName("Pune");
		memberPolicy.setProviderId(5);
		memberPolicy.setProviderName("HDFC");

		assertEquals(3, memberPolicy.getMemberId());
		assertEquals("Abhi", memberPolicy.getMemberName());
		assertEquals(2, memberPolicy.getPolicyId());
		assertEquals("2020-06-26", memberPolicy.getSubscriptionDate());
		assertEquals(3, memberPolicy.getLocationId());
		assertEquals("Pune", memberPolicy.getLocationName());
		assertEquals(5, memberPolicy.getProviderId());
		assertEquals("HDFC", memberPolicy.getProviderName());

	}
}
