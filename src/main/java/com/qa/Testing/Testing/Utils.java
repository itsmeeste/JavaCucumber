package com.qa.Testing.Testing;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Utils 
{
	private static XSSFWorkbook workbook = null;
	private static XSSFSheet sheet;
	
	private static boolean LoadFile(String filepath)
	{
		FileInputStream file = null;
		
		try
		{
			file = new FileInputStream(filepath);
		}
		catch(FileNotFoundException e)
		{
			try {
				file.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
			System.out.println(e);
			return false;
		}
		
		// Create the XSSF Book
		
		try {
			workbook = new XSSFWorkbook(file);
		} catch (IOException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				file.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return false;
		}
		
		return true;
	}
	
	private static boolean LoadSheet(int sheetNum)
	{
		sheet = workbook.getSheetAt(sheetNum);
		
		if(sheet == null)
			return false;
		return true;
	}
	
	public static XSSFCell getCell(String filepath,int sheetNum,int row,int cellNum)
	{
		XSSFCell cell = null; 
		if(workbook == null)
		{
			if(!LoadFile(filepath))
				return cell;
		}
		if(sheet == null)
		{
			if(!LoadSheet(sheetNum))
				return cell;
		}
		try
		{
			cell = sheet.getRow(row).getCell(cellNum);			
		}
		catch(NullPointerException ex)
		{
			System.out.println("Null Cell");
			return cell;
		}
		
		return cell;
		
		
	}

}
