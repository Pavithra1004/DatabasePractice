package Genric;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
public class ExcelMethodss {
		
	/**
	 * This is used to maintain all the excel specific common methods
	 * @author Pavithra
	 *
	 */
	
		/*
		 * This method is used to fetch the data from excel
		 */
		public void fetchDataFromExcel(String filePath,String sheetName,int rowNumber,int cellNumber) throws EncryptedDocumentException, IOException 
		{
			FileInputStream fis=new FileInputStream(filePath);
			Workbook wb = WorkbookFactory.create(fis);	
			String data = wb.getSheet(sheetName).getRow(rowNumber).getCell(cellNumber).toString();
			Reporter.log(data);
		}
		/*
		 * This method is used to write the data into excel
		 */
		public void setDataToExcel(String filePath,String sheetName,int rowNumber,int cellNumber,String data) throws EncryptedDocumentException, IOException
		{
			FileInputStream fis=new FileInputStream(filePath);
			Workbook wb = WorkbookFactory.create(fis);	
			wb.getSheet(sheetName).createRow(rowNumber).createCell(cellNumber).setCellValue(data);
			FileOutputStream fout=new FileOutputStream(filePath);
			wb.write(fout);
			
		}
		/*
		 * This method is used to fetch the multiple data from excel
		 */
		public void fetchMultipleDataFromExcel(String filePath,String sheetName,int cellNumber) throws EncryptedDocumentException, IOException
		{
			FileInputStream fis=new FileInputStream(filePath);
			Workbook wb = WorkbookFactory.create(fis);	
			 Sheet sheet = wb.getSheet(sheetName);
			 for(int i=0;i<sheet.getLastRowNum();i++)
			 {
				try
				 {
				Row row = sheet.getRow(i);
				Cell cell = row.getCell(cellNumber);
				Reporter.log(cell.toString());
				 }catch (Exception e) {
					e.getMessage();
				}
			 }
		}
		/*
		 * This method is used to write the multiple data into excel
		 */
		public void saveMultipleDataToExcel(String filePath,String sheetName,List<WebElement> ele,int cellNumber) throws EncryptedDocumentException, IOException
		{
			FileInputStream fis=new FileInputStream(filePath);
			Workbook wb = WorkbookFactory.create(fis);	
			 Sheet sheet = wb.getSheet(sheetName);
			 for (int i = 0; i < ele.size(); i++) {
				 Row row = sheet.createRow(i+1);
				 Cell cell = row.createCell(cellNumber);
				  cell.setCellValue(ele.get(i).getAttribute("href"));
			}		 
			 FileOutputStream fout=new FileOutputStream(filePath);
				wb.write(fout);
		}
		public void setMultipleDataToExcel(String filePath,String sheetName,List<WebElement> ele,int cellNum,String data) throws IOException
		{
		FileInputStream fis=new FileInputStream(filePath);
		Workbook wb = WorkbookFactory.create(fis);	
		Sheet s = wb.getSheet(sheetName);
		for(int i=0;i<ele.size();i++)
		{	
			
			Row r = s.createRow(i+1);			
			Cell c1 = r.createCell(cellNum);
			c1.setCellValue(data);		
			
		}
		
		
		FileOutputStream fout=new FileOutputStream(filePath);
		wb.write(fout);
		wb.close();
		}
		
	}


