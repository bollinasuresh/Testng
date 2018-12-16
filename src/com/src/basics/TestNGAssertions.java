package com.src.basics;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestNGAssertions {

	/*
	 * @Test(priority = 1) public void login() { Assert.assertEquals("Title",
	 * "title"); System.out.println("Login"); }
	 * 
	 * @Test(priority = 2, dependsOnMethods = "login") public void logout() {
	 * System.out.println("Logout"); }
	 */
	SoftAssert soft = new SoftAssert();

	@Test(priority = 1)
	public void login() {
		soft.assertEquals("title", "Title");
		System.out.println("Login");
		soft.assertAll();
	}

	@Test(priority = 2)
	public void logout() {
		System.out.println("Logout");
	}
}
