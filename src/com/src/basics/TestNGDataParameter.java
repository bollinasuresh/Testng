package com.src.basics;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNGDataParameter extends ReadExcelData {
	@Parameters("userName")
	@Test
	private void getParameter(String user) {
		System.out.println("XmlParameter " + user);
	}

	@Test(dataProvider = "getData")
	public void login(String user, String pass) {
		System.out.println("Username " + user + " Password " + pass);
	}

	@DataProvider
	public Object[][] getData() throws InvalidFormatException, IOException {
		/*
		 * Object[][] data = new Object[2][2]; data[0][0] = "User1"; data[0][1]
		 * = "Pass1"; data[1][0] = "User2"; data[1][1] = "Pass2"; return data;
		 */
		return getSheetData("Datasheet");
	}

}
