package com.src.basics;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelData {

	public static Object[][] getSheetData(String sName) throws IOException, InvalidFormatException {
		String filePath = System.getProperty("user.dir") + "\\TestData.xlsx";
		System.out.println(filePath);
		Object[][] data = null;
		XSSFWorkbook workbook = new XSSFWorkbook(new File(filePath));
		int noOfSheets = workbook.getNumberOfSheets();
		System.out.println("Number of Sheets - " + workbook.getNumberOfSheets());
		for (int i = 0; i < noOfSheets; i++) {
			System.out.println(i + " - " + workbook.getSheetName(i));
			String sheetName = workbook.getSheetName(i);
			if (sheetName.equals(sName)) {
				Sheet sheet = workbook.getSheet(sName);
				int rowCount = sheet.getLastRowNum();
				Row rowHeader = sheet.getRow(0);
				System.out.println("Total Rows " + rowCount);
				System.out.println("Total Cols " + rowHeader.getLastCellNum());
				int colCount = rowHeader.getLastCellNum();
				data = new Object[rowCount][colCount];
				for (int row = 1; row <= sheet.getLastRowNum(); row++) {
					Row rows = sheet.getRow(row);
					for (int col = 0; col < rows.getLastCellNum(); col++) {
						Cell cell = rows.getCell(col);
						switch (cell.getCellType()) {
						case STRING:
							System.out.println("string data " + cell.getRichStringCellValue().getString());
							data[row - 1][col] = cell.getRichStringCellValue().getString();
							break;
						case NUMERIC:
							if (DateUtil.isCellDateFormatted(cell)) {
								System.out.print(cell.getDateCellValue());
							} else {
								System.out.println("numeric data " + cell.getNumericCellValue());
								data[row - 1][col] = cell.getNumericCellValue();
							}
							break;
						default:
							break;
						}
					}
				}
			}
		}
		workbook.close();
		return data;
	}
}