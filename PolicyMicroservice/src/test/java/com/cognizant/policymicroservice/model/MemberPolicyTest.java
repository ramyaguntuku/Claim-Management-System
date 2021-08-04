package com.cognizant.policymicroservice.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/*
 * Test Cases for MemberPolicy class
 */
@SpringBootTest
@RunWith(SpringRunner.class)
class MemberPolicyTest {

	
	public MemberPolicy memberPolicy;

	@BeforeEach
	void setUp() throws ParseException {
		String sdate = "24/06/2021";
		Date date = new SimpleDateFormat("dd/MM/yyyy").parse(sdate);
		memberPolicy = new MemberPolicy();
		memberPolicy.setMemberId(1);
		memberPolicy.setPolicyId(1);
		memberPolicy.setPolicyNumber(101);
		memberPolicy.setBenefitId(202);
		memberPolicy.setSubscriptionDate(date);
		memberPolicy.setTenure(21);
		memberPolicy.setCapAmountBenefits(100000.00);
		memberPolicy = new MemberPolicy(1, 1, 101, 201, date, 21, 100000.00);
	}
	/*
	 * test if the MemberPolicy class is working properly
	 */
	@Test
	public void setterTest() throws ParseException {
		String sdate = "24/06/2021";
		Date date = new SimpleDateFormat("dd/MM/yyyy").parse(sdate);
		assertEquals(1, memberPolicy.getMemberId());
		assertEquals(1, memberPolicy.getPolicyId());
		assertEquals(101, memberPolicy.getPolicyNumber());
		assertEquals(201, memberPolicy.getBenefitId());
		assertEquals(date, memberPolicy.getSubscriptionDate());
		assertEquals(21, memberPolicy.getTenure());
		assertEquals(100000.00, memberPolicy.getCapAmountBenefits());
	}

	/*
	 * tests the MemberPolicy class NoArgsConstructor
	 */
	@Test
	public void noArgsConstructorTest() {
		MemberPolicy memberPolicy1 = new MemberPolicy();
		assertEquals(memberPolicy1, memberPolicy1);
	}

	/*
	 * tests the MemberPolicy class AllArgsConstructor
	 */
	@Test
	public void allArgsConstructorTest() throws ParseException {
		String sdate = "24/06/2021";
		Date date = new SimpleDateFormat("dd/MM/yyyy").parse(sdate);
		MemberPolicy memPolicy = new MemberPolicy(1, 1, 101, 201, date, 21, 100000.00);
		assertEquals(1,memPolicy.getMemberId());
		assertEquals(1,memPolicy.getPolicyId());
		assertEquals(101,memPolicy.getPolicyNumber());
		assertEquals(201,memPolicy.getBenefitId());
		assertEquals(date,memPolicy.getSubscriptionDate());
		assertEquals(21,memPolicy.getTenure());
		assertEquals(100000.00,memPolicy.getCapAmountBenefits());
	}


	
}
