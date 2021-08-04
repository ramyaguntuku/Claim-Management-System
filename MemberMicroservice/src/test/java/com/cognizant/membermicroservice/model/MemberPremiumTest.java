package com.cognizant.membermicroservice.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 
 * This class contains test cases for the MemberPremium model class which are
 * written using junit
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class MemberPremiumTest {

	@Mock
	private MemberPremium memberPremium;

	/**
	 * 
	 * Testing MemberPremium is not null
	 */

	@Test
	@DisplayName("Checking if MemberPolicy class is loading or not.")
	void memberPremiumIsLoadedOrNot() {
		assertThat(memberPremium).isNotNull();
	}

	/**
	 * 
	 * Testing MemberPremium constructor
	 */

	@DisplayName("Checking if MemberPolicy class is responding correctly or not.")
	@Test
	void testingMemberPremium() throws ParseException {
		String sDate1 = "31/12/2020";
		String sDate2 = "10/01/2021";
		Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
		Date date2 = new SimpleDateFormat("dd/MM/yyyy").parse(sDate2);
		memberPremium = new MemberPremium();
		memberPremium.setMemberId(3);
		memberPremium.setPolicyId(2);
		memberPremium.setPaidDate(date1);
		memberPremium.setDueDate(date2);
		memberPremium.setPremium(9000);
		memberPremium.setLatePaymentCharges(0);
		memberPremium.setLatePayment(false);

		assertEquals(3, memberPremium.getMemberId());
		assertEquals(2, memberPremium.getPolicyId());
		assertEquals(date1, memberPremium.getPaidDate());
		assertEquals(date2, memberPremium.getDueDate());
		assertEquals(9000, memberPremium.getPremium());
		assertEquals(0, memberPremium.getLatePaymentCharges());
		assertEquals(false, memberPremium.isLatePayment());

	}
}
