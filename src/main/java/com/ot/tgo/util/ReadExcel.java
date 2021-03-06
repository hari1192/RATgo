package com.ot.tgo.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadExcel {

	public static void main(String[] args) throws InvalidFormatException, IOException {
		try{
			FileInputStream file =new FileInputStream("\\Users\\vsrihari\\Desktop\\RA_HC_TC.xls");
			Workbook book=WorkbookFactory.create(file);
			Sheet sheet=book.getSheet("GXS Cust HC");
			Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
			// System.out.println(sheet.getLastRowNum() + "--------" +
			// sheet.getRow(0).getLastCellNum());
			for (int i = 0; i < sheet.getLastRowNum(); i++) {
				for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
					data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
					 System.out.println(data[i][k]);
				}
			}
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	
	}

}
