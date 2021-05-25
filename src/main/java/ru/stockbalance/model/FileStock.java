package ru.stockbalance.model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class FileStock{


public void readFromExcel (String file) throws IOException, FileNotFoundException  {
	HSSFWorkbook excleBook = null;
	FileInputStream fis = null;
	
	try {
		fis = new FileInputStream(file);
		excleBook = new HSSFWorkbook(fis);
		HSSFSheet excelSheet = excleBook.getSheetAt(0);
		HSSFRow row = excelSheet.getRow(0);
		
		if (row.getCell(0) != null) {
			int val = (int) row.getCell(1).getNumericCellValue(); 
			System.out.print(val);
		}
	}catch (FileNotFoundException e) {
		System.out.println("FileNotFoundException - File not found!");
		System.out.println(e.getMessage());
	}
	catch (IOException e) {
		System.out.println("IOException - bich!");
		System.out.println(e.getMessage());
	} 
	finally {
		if (fis != null) {
			fis.close();
		}
	}
	
}
	
}
