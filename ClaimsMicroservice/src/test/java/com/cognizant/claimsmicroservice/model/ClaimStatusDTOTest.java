package com.cognizant.claimsmicroservice.model;


import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * 
 * This class contains test cases for the ClaimStatusDTO class which are written
 * using junit
 */
@SpringBootTest
@RunWith(SpringRunner.class)
class ClaimStatusDTOTest {

	ClaimStatusDTO claimStatusDto=new ClaimStatusDTO();
	
    @Test
     void testClaimStatus(){
    	claimStatusDto.setClaimStatus("Claimed");
        assertEquals("Claimed",claimStatusDto.getClaimStatus());   
    }
    @Test
    void testDescription() {
    claimStatusDto.setDescription("LIC Claim");
    assertEquals("LIC Claim",claimStatusDto.getDescription());
    }
}
