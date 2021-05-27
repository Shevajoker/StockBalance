package ru.stockbalance.model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import ru.stockbalance.services.ArticleService;


public class FileStock{


public void readFromExcel (String file) throws IOException, FileNotFoundException  {
	HSSFWorkbook excleBook = null;
	FileInputStream fis = null;
	URLConnection urlCon = null;
	HSSFSheet excelSheet = null;
	String article = null;
	String name = null;
	int count = -1;

	
	try {
		URL url = new URL(file);
		urlCon = url.openConnection();
		excleBook = new HSSFWorkbook(urlCon.getInputStream());
		excelSheet = excleBook.getSheetAt(0);
	
	}catch (FileNotFoundException e) {
		System.out.println("FileNotFoundException - File not found!");
		System.out.println(e.getMessage());
	}
	catch (IOException e) {
		System.out.println("IOException - bich!");
		System.out.println(e.getMessage());
	} 
	catch (NullPointerException e) {
		System.out.println("NullPointerException - bich!");
		System.out.println(e.getMessage());
	}
	finally {
		if (fis != null) {
			fis.close();
		}
		
	}
	
	
	
for (Row rows : excelSheet ) {
		
		
		// article in cell - 0
		Cell cell = rows.getCell(0); 
		//check empty cell
		if (cell == null || cell.getCellType() == CellType.BLANK) {
			 System.out.println("Cell ARTICLE is empty");
			} else {
		//read article
		switch (cell.getCellType()) {
        case STRING:
//            System.out.println(cell.getRichStringCellValue().getString());
            article = cell.getStringCellValue();
            break;
        case NUMERIC:
            if (DateUtil.isCellDateFormatted(cell)) {
            } else {
            }
            break;
        case BOOLEAN:
            break;
        case FORMULA:
            break;
        case BLANK:
            System.out.println();
            break;
        case _NONE:
            System.out.println("NONE");
            break;
        case ERROR:
            System.out.println("ERROR");
            break;
        default:
            System.out.println("-?-");
		}
		
	}
	
		// name in cell - 1
		cell = rows.getCell(1); 
		//check empty cell
		if (cell == null || cell.getCellType() == CellType.BLANK) {
			 System.out.println("Cell NAME is empty");
			} else {
		//read article
		switch (cell.getCellType()) {
        case STRING:
//            System.out.println(cell.getRichStringCellValue().getString());
            name = cell.getStringCellValue();
            break;
        case NUMERIC:
            if (DateUtil.isCellDateFormatted(cell)) {
            } else {
            }
            break;
        case BOOLEAN:
            break;
        case FORMULA:
            break;
        case BLANK:
            System.out.println();
            break;
        case _NONE:
            System.out.println("NONE");
            break;
        case ERROR:
            System.out.println("ERROR");
            break;
        default:
            System.out.println("-?-");
		}
		
	}
		
		
		// count in cell - 2
		cell = rows.getCell(2); 
		//check empty cell
		if (cell == null || cell.getCellType() == CellType.BLANK) {
//			 System.out.println("Cell COUNT is empty");
			} else {
		//read article
		switch (cell.getCellType()) {
        case STRING:
            break;
        case NUMERIC:
            if (DateUtil.isCellDateFormatted(cell)) {
            } else {
            	count = (int) cell.getNumericCellValue();
            }
            break;
        case BOOLEAN:
            break;
        case FORMULA:
            break;
        case BLANK:
            System.out.println();
            break;
        case _NONE:
            System.out.println("NONE");
            break;
        case ERROR:
            System.out.println("ERROR");
            break;
        default:
            System.out.println("-?-");
		}
		
	}	
		
		
		
		
		Article articleForDB = new Article(article, name, count);
		ArticleService articleService = new ArticleService();
		
//		if (articleForDB.getStock() > -1 || articleForDB.equals(null)) {
//		System.out.println(articleForDB.toString());
//		articleService.saveArticle(articleForDB);
//		
//		}
		
		
		
//		System.out.println(article + " |*| " + name + "|*|" + count);
	
		
		article = null;
		name = null;
		count = -1;	
}	
	
	
}
	
}
