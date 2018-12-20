package com.src.basics;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryExample {

	@Test(retryAnalyzer=com.src.basics.RetryMethods.class)
	public void testA() {
		Assert.assertEquals(false, true);
	}

	@Test()
	public void testB() {
		Assert.assertEquals(false, true);
	}
}
