package com.tbs.shoptouch.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excelutil {
	static Workbook book;
	static Sheet sheet;
	static Object[][] data =null;

	public static Object[][] getTestdata(String SheetName) throws InvalidFormatException, IOException{
			// TODO Auto-generated method stub
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\Testdata\\testdata.xls");
			book =WorkbookFactory.create(fis);
			sheet =book.getSheet(SheetName);
			data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
			
			for(int i=0;i<sheet.getLastRowNum();i++) {
				for(int k=0; k< sheet.getRow(0).getLastCellNum();k++) {
				//data[i][k]= sheet.getRow(i+1).getCell(k).toString();
				data[i][k]= sheet.getRow(i+1).getCell(k);
				if(data[i][k]!=null) {

					int type = ((HSSFCell) data[i][k]).getCellType();
					if (type == HSSFCell.CELL_TYPE_STRING) {
						System.out.println(((HSSFCell) data[i][k]).getRichStringCellValue().toString());
						data[i][k]=((HSSFCell) data[i][k]).getRichStringCellValue().toString();
					}
					else if (type == HSSFCell.CELL_TYPE_NUMERIC) {
						System.out.println(new DataFormatter().formatCellValue((Cell) data[i][k]));
						data[i][k]=(((HSSFCell) data[i][k]).getNumericCellValue());
					}
					else if (type == HSSFCell.CELL_TYPE_BOOLEAN)
						System.out.println( ((HSSFCell) data[i][k]).getBooleanCellValue());
					else if (type == HSSFCell.CELL_TYPE_BLANK)
						System.out.println(((HSSFCell) data[i][k]).getColumnIndex() + "] = BLANK CELL");
				}
			}
			}
			//System.out.println(data);
			//return data;
			return data;
			
	}
		

}
