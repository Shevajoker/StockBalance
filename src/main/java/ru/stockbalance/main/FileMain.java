package ru.stockbalance.main;

import java.io.IOException;
//import java.net.URL;

import ru.stockbalance.model.FileStock;

public class FileMain {

	
	
	public static void main(String[] args) throws IOException {
		
		FileStock file = new FileStock();
//		String fileDir = "E:\\24 05 2021\\ost.xls";
		String fileDir =  "http://77.74.28.4:22181/brw/ostatki.xls";
		
//		URL url = new URL("http://77.74.28.4:22181/brw/ostatki.xls");
//		String fileDir = url.getFile();
		file.readFromExcel(fileDir);
		
	}
	
}
