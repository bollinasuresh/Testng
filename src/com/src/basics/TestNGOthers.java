package com.src.basics;

import org.testng.annotations.Test;

public class TestNGOthers {

	@Test(invocationCount = 10, timeOut =1)
	public void testA() {
		System.out.println("Testing");
	}

}
