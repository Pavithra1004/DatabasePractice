package Genric;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * This is used to maintain all the excel specific common methods
 * @author anand
 *
 */
public class ExcelMethods {
	/**
	 * This is used to open the excel 
	 * 
	 */
	 public Workbook wb;
	/**
	 * This method is used to open the excel
	 * @param filePath
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public  void openExcel(String filePath) throws EncryptedDocumentException, IOException 
	{
		FileInputStream fis=new FileInputStream(filePath);
		wb = WorkbookFactory.create(fis);	
	}
	/**
	 * This method is used to save the excel file
	 * @param saveFilePath
	 * @throws IOException
	 */
	public  void saveExcelData(String saveFilePath)
	{
		FileOutputStream fout = null;
		try {
			fout = new FileOutputStream(saveFilePath);
		} catch (FileNotFoundException e) {
			System.out.println("Exception");
			e.printStackTrace();
		}
		try {
			wb.write(fout);
		} catch (IOException e) {
			
			e.printStackTrace();
		}	
	}
	/**
	 * This method is used to fetch the data from the excel sheet
	 * @param sheetName
	 * @param rowNumber
	 * @param cellNumber
	 * @return
	 */
	public  String getDataFromExcel(String sheetName,int rowNumber,int cellNumber)
	{
		String data = wb.getSheet(sheetName).getRow(rowNumber).getCell(cellNumber).getStringCellValue();
		return data;
	}
	/**
	 * This method is used to Fetch multiple data from excel
	 * @param sheetName
	 * @return
	 */
	public  Object[][] getMultipleDataFromExcelToString(String sheetName)
	{
		Sheet sheet = wb.getSheet(sheetName);

		Object[][] arr=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for(int i=0;i<sheet.getLastRowNum();i++)
			
		{
			for(int j=0;j<sheet.getRow(i).getLastCellNum();j++)
			{
				arr[i][j]=sheet.getRow(i).getCell(j).toString();
				
			}
		}
		return arr;
	}
	/**
	 * This method is used to Get the data from excel
	 * @param sheetName
	 * @param rowNumber
	 * @param cellNumber
	 * @return
	 */
	

	public  String getDataFromExcelToString(String sheetName,int rowNumber,int cellNumber)
	{
		String data = wb.getSheet(sheetName).getRow(rowNumber).getCell(cellNumber).toString();
		return data;
	}
	/**
	 * This method is used to write the data into excel
	 * @param sheetName
	 * @param rowNumber
	 * @param cellNumber
	 * @param data
	 */
	public  void setDataIntoExcelCreate(String sheetName,int rowNumber,int cellNumber,String data)
	{
		wb.getSheet(sheetName).createRow(rowNumber).createCell(cellNumber).setCellValue(data);

	}
	public  void setDataIntoExcel(String sheetName,int rowNumber,int cellNumber,String data)
	{
		wb.getSheet(sheetName).getRow(rowNumber).createCell(cellNumber).setCellValue(data);

	}
	/**
	 * This method is used to close the connection
	 * @throws IOException
	 */
	public  void closeExcel() throws IOException
	{
		wb.close();
	}
}
