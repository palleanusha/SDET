package com.Vtiger.genericUtil;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {
	public static ExcelUtil objForExceleUtil()
	{
		ExcelUtil prop=new ExcelUtil();
		return prop;
	}

	public String readDataFromExcelFile(String sheetname,int row,int cell) throws IOException {
		FileInputStream fis=new FileInputStream(IAutoConstants.Excelpath);
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet=workbook.getSheet(sheetname);
		Row row1=sheet.getRow(row);
		String excelvalue=row1.getCell(cell).getStringCellValue();
		
		return excelvalue;
	}

	/**
	 * reads the last row value
	 * @throws IOException 
	 * 
	 */
	public String getLastRow(String sheet,int cell,String dropdvalue) throws IOException {

		FileInputStream fis=new FileInputStream(IAutoConstants.Excelpath);
		Workbook wb= WorkbookFactory.create(fis);
		int rowCount=wb.getSheet(sheet).getLastRowNum();
		String lastrow="null";
		for(int i=0;i<rowCount;i++) {
			lastrow=wb.getSheet(sheet).getRow(i).getCell(cell).getStringCellValue().toString();
			if(lastrow.equalsIgnoreCase(dropdvalue));
			{
				break;
			}


		}
		return lastrow;
	}
}


