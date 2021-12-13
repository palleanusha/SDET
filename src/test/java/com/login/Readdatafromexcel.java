package com.login;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Readdatafromexcel {

	public static void main(String[] args) throws IOException {
		String dirpath = System.getProperty("user.dir");
		String Excelpath = dirpath+"\\reaadandwrite.xlsx";
		FileInputStream fis = new FileInputStream(Excelpath);
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet("Sheet1");
		Row row=sheet.getRow(1);
		double value = row.getCell(1).getNumericCellValue();
		//int a=Integer.parseInt(value);
		System.out.println(value);
	}
}







