package com.wrap.auto.sampleproject.tests;

import java.util.HashMap;

import org.testng.annotations.Test;

public class NewUserSingUpTest extends BaseTest {

	@Test
	public void registerNewUserTest() {

		homePage.get().navToFreeTrial().signupUsingEmail("aaa12345@gmai.com")
				.withUser("aaa12345").withPassword("password123").and()
				.createAccount(new HashMap<String, String>() {
					{
						put("firstName", "testUser1234");
						put("lastName", "testUserLN");
						put("company", "testCompany");
					}
				});
	}

}
