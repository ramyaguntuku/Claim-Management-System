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
 * This class contains test cases for the Member model class which are written
 * using junit
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class MemberTest {

	@Mock
	private Member member;

	/**
	 * 
	 * Testing Member is not null
	 */

	@Test
	@DisplayName("Checking if Member class is loading or not.")
	void memberIsLoadedOrNot() {
		assertThat(member).isNotNull();
	}

	/**
	 * 
	 * Testing Member constructor
	 */

	@DisplayName("Checking if Member class is responding correctly or not.")
	@Test
	void testingMember() {

		member = new Member(1, "Abhi", "9898767876", 15000, "Male");
		member.setMemberId(3);
		member.setMemberName("Bruce");
		member.setPhoneNumber("8998765434");
		member.setSalary(20000);
		member.setGender("Male");

		assertEquals(3, member.getMemberId());
		assertEquals("Bruce", member.getMemberName());
		assertEquals("8998765434", member.getPhoneNumber());
		assertEquals(20000, member.getSalary());
		assertEquals("Male", member.getGender());

	}
}
