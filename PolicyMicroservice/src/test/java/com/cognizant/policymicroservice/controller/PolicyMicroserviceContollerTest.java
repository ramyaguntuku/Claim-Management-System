package com.cognizant.policymicroservice.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.cognizant.policymicroservice.client.AuthClient;
import com.cognizant.policymicroservice.model.AuthenticationResponse;
import com.cognizant.policymicroservice.model.Benefits;
import com.cognizant.policymicroservice.model.MemberPolicy;
import com.cognizant.policymicroservice.model.ProviderPolicy;
import com.cognizant.policymicroservice.repository.BenefitRepo;
import com.cognizant.policymicroservice.repository.MemberPolicyRepo;
import com.cognizant.policymicroservice.repository.ProviderPolicyRepo;

/*
 * Test cases for getBenefitId method in policyMicroservice Controller
 */
@SpringBootTest
@RunWith(SpringRunner.class)
class PolicyMicroserviceContollerTest {

	@InjectMocks
	PolicyMicroserviceContoller policyMicroserviceController;

	@Mock
	BenefitRepo benefitRepo;
	
	@Mock
	private ProviderPolicy providerPolicy;

	@Mock
	private AuthClient authClient;
	
	@Mock
	ProviderPolicyRepo providerPolicyRepo;
	@Mock
	MemberPolicy memberPolicy;
	@Mock
	List<Benefits> benefitDetails;
	@Mock
	MemberPolicyRepo memberPolicyRepo;
	
	/*
	 * test the getBenefitId method with positive inputs
	 */
	@Test
	void testGetBenefitId() {
		Benefits benefits = new Benefits();
		benefits.setBenefitId(1);
		benefits.setBenefitName("Health Checkup");
		when(benefitRepo.findByBenefitId(1)).thenReturn(benefits);
		assertEquals(1, benefitRepo.findByBenefitId(1).getBenefitId());
	}

	/*
	 * test the getBenefitId method with negative inputs
	 */
	@Test
	void testGetBenefitId_negative() {
		Benefits benefits = new Benefits();
		benefits.setBenefitId(-1);
		benefits.setBenefitName("Health Checkup");
		assertNotEquals(1, benefits.getBenefitId());
	}
	@Test
	public void getChainOfProvidersTest() {

		AuthenticationResponse response = new AuthenticationResponse("token", true);
		ResponseEntity<ProviderPolicy> providers = new ResponseEntity<ProviderPolicy>(providerPolicy, HttpStatus.OK);
		when(authClient.getValidity("token")).thenReturn(response);
		assertEquals(providers.getStatusCodeValue(),
				policyMicroserviceController.getChainOfProviders(1, "token").getStatusCodeValue());
	}
	@Test
	void GetEligibleBenefits_test() {
		AuthenticationResponse response = new AuthenticationResponse("token", true);
		ResponseEntity<MemberPolicy> benefits = new ResponseEntity<MemberPolicy>(memberPolicy, HttpStatus.OK);
		when(authClient.getValidity("token")).thenReturn(response);
		assertEquals(benefits.getStatusCodeValue(),
				policyMicroserviceController.getEligibleBenefits(1, 1, "token").getStatusCodeValue());
	}
	@Test
	void getEligibleClaimAmount_test() {
		AuthenticationResponse response = new AuthenticationResponse("token", true);
		when(authClient.getValidity("token")).thenReturn(response);
		when(memberPolicyRepo.findCapAmount(1,1,1)).thenReturn(memberPolicy);

		assertEquals(HttpStatus.OK, policyMicroserviceController.getEligibleClaimAmount(1,1,1,"token").getStatusCode());
	}

	
}
