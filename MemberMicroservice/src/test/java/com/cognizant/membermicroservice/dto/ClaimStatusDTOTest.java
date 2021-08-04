package com.cognizant.membermicroservice.dto;

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
 * This class contains test cases for the ClaimStatusDTO class which are written
 * using junit
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class ClaimStatusDTOTest {

	@Mock
	private ClaimStatusDTO claimStatusDTO;

	/**
	 * Test the ClaimStatusDTO is not null
	 */

	@Test
	@DisplayName("Checking if ClaimStatusDTO class is loading or not.")
	void claimStatusDTOIsLoadedOrNot() {
		assertThat(claimStatusDTO).isNotNull();
	}

	/**
	 * Test the ClaimStatusDTO constructor
	 */

	@DisplayName("Checking if ClaimStatusDTO class is responding correctly or not.")
	@Test
	void testingMember() {

		claimStatusDTO = new ClaimStatusDTO("Not Claimed", "Medibuddy Claim");
		claimStatusDTO.setClaimStatus("Claimed");
		claimStatusDTO.setDescription("LIC Claim");

		assertEquals("Claimed", claimStatusDTO.getClaimStatus());
		assertEquals("LIC Claim", claimStatusDTO.getDescription());

	}
}
