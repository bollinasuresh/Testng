package com.src.basics;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGAnnotations {

	@BeforeClass
	public void beforeClass() {
		System.out.println("Before Class");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("After Class");
	}

	@Test(priority = 0)
	public void appleTest() {

		boolean flase = true;
		Assert.assertFalse(flase);
		System.out.println("Apple test");
	}

	@Test(priority = 1, dependsOnMethods = "appleTest")
	public void audiTest() {
		Assert.assertTrue(2 > 1);
		throw new SkipException("Testcase skipped");
		/*
		 * Assert.fail("Made to fail"); System.out.println("Audi test");
		 */
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("Before Test");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("After Test");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Before Method");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("After Method");
	}
}
