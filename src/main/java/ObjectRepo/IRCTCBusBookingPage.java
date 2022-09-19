package ObjectRepo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import com.mysql.cj.jdbc.Driver;

import Genric.ExcelMethods;

public class IRCTCBusBookingPage {
	String filePath="D:\\TySelenium\\TYSSProject\\DataSet.xlsx";
	String sheetName="IRCTCBusBooking";

	public IRCTCBusBookingPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	/*
	 * click alert
	 */
	@FindBy(xpath = "//button[text()='OK']")
	private WebElement alert;


	public void alertClick()
	{
		alert.click();
	}
	/*
	 * Fetching HeaderNames
	 */
	@FindBy(xpath = "//div[@class='row col-sm-12 h_head1']//a")
	private List<WebElement> headers1;

	public void headerName1() throws EncryptedDocumentException, IOException
	{
		//		FileInputStream fis=new FileInputStream("D:\\TySelenium\\TYSSProject\\DataSet.xlsx");
		//	Workbook wb = WorkbookFactory.create(fis);	
		//	org.apache.poi.ss.usermodel.Sheet s = wb.getSheet("Sheet1");
		System.out.println(headers1.size());
		for(int i=0;i<headers1.size();i++)
		{

			//				org.apache.poi.ss.usermodel.Row r = s.createRow(i+1);			
			//				org.apache.poi.ss.usermodel.Cell c1 = r.createCell(0);
			//				c1.setCellValue(headers1.get(i).getText());
			System.out.println(headers1.get(i).getText());

		}

		//			FileOutputStream fout=new FileOutputStream("D:\\TySelenium\\TYSSProject\\DataSet.xlsx");
		//			wb.write(fout);
		//			wb.close();

	}


	/*
	 * Fetching 2nd HeaderNames
	 */
	@FindBy(xpath = "//div[@class='row col-sm-12 h_head2']/nav/ul/li/a")
	private List<WebElement> headers2;

	public void headerName2() throws EncryptedDocumentException, IOException
	{
		//		FileInputStream fis=new FileInputStream("D:\\TySelenium\\TYSSProject\\DataSet.xlsx");
		//		Workbook wb = WorkbookFactory.create(fis);	
		//		org.apache.poi.ss.usermodel.Sheet s = wb.getSheet("Sheet1");
		System.out.println(headers2.size());
		for(int i=0;i<headers2.size();i++)
		{

			//					org.apache.poi.ss.usermodel.Row r = s.createRow(i+13);			
			//					org.apache.poi.ss.usermodel.Cell c1 = r.createCell(0);
			//					c1.setCellValue(headers2.get(i).getText());
			System.out.println(headers2.get(i).getText());

		}

		//				FileOutputStream fout=new FileOutputStream("D:\\TySelenium\\TYSSProject\\DataSet.xlsx");
		//				wb.write(fout);
		//				wb.close();
	}
	/*
	 * Bus clicking
	 */

	@FindBy(xpath = "//a[text()=' BUSES ']")
	private WebElement bus;

	public void busClick()
	{
		bus.click();
	}

	/*
	 * Switch to next Window
	 */
	public void switchWindow(WebDriver driver,String ele)
	{
		Set<String> window = driver.getWindowHandles();
		for(String Id:window)
		{
			driver.switchTo().window(Id);
			if(driver.getTitle().contains(ele))
			{
				break;
			}
		}
	}
	/*
	 * click departureFrom
	 */
	@FindBy(id = "departFrom")
	private WebElement departFrom;

	@FindBy(xpath = "//ul[@class='ui-menu ui-widget ui-widget-content ui-autocomplete ui-front']/li/div[@class='ui-menu-item-wrapper']")
	private List<WebElement> dCity;

	@FindBy(xpath = "//ul[@class='ui-menu ui-widget ui-widget-content ui-autocomplete ui-front']/li/div[@class='ui-menu-item-wrapper']")
	private WebElement dclick;

	public void departFromSelect(WebDriver driver,String from)
	{
		departFrom.sendKeys(from);

		for(WebElement d:dCity)
		{
			System.out.println(d.getText());
		}
		for(int i=0;i<dCity.size();i++)
		{
			if(from.equals(dCity.get(i).getText()))
			{
				dclick.click();
				break;

			}
		}
	}
	/*
	 * select to city
	 */
	@FindBy(id = "goingTo")
	private WebElement goingTo;

	@FindBy(xpath = "//ul[@class='ui-menu ui-widget ui-widget-content ui-autocomplete ui-front']/li/div[contains(.,'Tu')]")
	private List<WebElement> tCity;

	@FindBy(xpath = "//ul[@class='ui-menu ui-widget ui-widget-content ui-autocomplete ui-front']/li/div[contains(.,'Tu')]")
	private WebElement tclick;

	public void toSelect(WebDriver driver,String to)
	{
		goingTo.sendKeys(to);

		for(WebElement d:tCity)
		{
			System.out.println(d.getText());
		}
		for(int i=0;i<tCity.size();i++)
		{
			if(to.equals(tCity.get(i).getText()))
			{
				tclick.click();
				break;

			}
		}
	}
	/*
	 * select date
	 */
	@FindBy(xpath =  "//a[text()='25']")
	private WebElement date;
	public void dateSelect()
	{
		date.click();
	}


	/*
	 * Search Bus
	 */
	@FindBy(xpath =  "//button[text()='Search Bus ']")
	private WebElement searchBusBtn;
	public void searchBus()
	{
		searchBusBtn.click();
	}

	/*
	 * After 6 pm click
	 */
	@FindBy(xpath =  "//h4[text()='Arrival Time']/parent::div//li//label[text()='After 6 pm']")
	private WebElement after6PM;
	public void clickAfter6PM()
	{
		after6PM.click();
	}
	/*
	 * Fetching departure 
	 */
	@FindBy(xpath = "//div[@class='SearchCard SearchCard01']/label")
	private List<WebElement> busName;

	@FindBy(xpath = "//div[@class='SearchCard SearchCard02']/label")
	private List<WebElement> departureTime;

	@FindBy(xpath = "//div[@class='SearchCard SearchCard04']/label")
	private List<WebElement> arrivalTime;

	@FindBy(xpath = "//div[@class='SearchCard SearchCard05']/label")
	private List<WebElement> price;

	public void getData(WebDriver driver) throws EncryptedDocumentException, IOException, SQLException
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		for(int i=0;i<=15;i++)
		{
			jse.executeScript("window.scrollBy(0,350)");
		}
//storing data into excel
		for(int i=0;i<busName.size();i++)
		{
			System.out.println(busName.get(i).getText());
			System.out.println(departureTime.get(i).getText());
			System.out.println(arrivalTime.get(i).getText());
			System.out.println(price.get(i).getText());
			ExcelMethods excelMethods=new ExcelMethods();
			excelMethods.openExcel(filePath);
			excelMethods.setDataIntoExcelCreate(sheetName, i+1, 0, busName.get(i).getText());
			excelMethods.setDataIntoExcel(sheetName, i+1, 1, departureTime.get(i).getText());
			excelMethods.setDataIntoExcel(sheetName, i+1, 2, arrivalTime.get(i).getText());
			excelMethods.setDataIntoExcel(sheetName, i+1, 3, price.get(i).getText());
			excelMethods.saveExcelData(filePath);
			excelMethods.closeExcel();
		}
		
//Stroring data into Database
		Driver driver1=new Driver();
		DriverManager.registerDriver(driver1);
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pro", "Pavithra", "Root@123");
		Statement statement = connection.createStatement();
		
		try {
			int j=1;
			for(int i=0;i<=busName.size()-1;i++)
			{
				int result1=statement.executeUpdate("insert into IRCTCBusBooking values('"+j+"','"+busName.get(i).getText()+"','"+departureTime.get(i).getText()+"','"+arrivalTime.get(i).getText()+"','"+price.get(i).getText()+"');");
				j++;
				if(result1>=1)
				{
					System.out.println("Data inserted successfully"+i);
				}
			}
		}catch(Exception e)
		{
			e.getMessage();
		}
		System.out.println("SLN" +"		"+"busName "+" 	 			 "+"departureTime"+" 	"+" arrivalTime"+"	 	 "+"price");
		 ResultSet result1 = statement.executeQuery("select * from IRCTCBusBooking;");
		 while(result1.next())
		 {
			 
			 System.out.println(result1.getString(1)+ "		"+result1.getString(2)+"			"+result1.getString(3)+"	 "+result1.getString(4)+"	 "+result1.getString(5));
		 }

				
		//validation of Busname
		
		ArrayList<String> list=new ArrayList<String>();
		for(WebElement bus:busName)
		{
			list.add(bus.getText());
		}
		
		ArrayList<String> list1=new ArrayList<String>();
		ResultSet result2 = statement.executeQuery("select busName from IRCTCBusBooking;");
		
		while(result2.next())
		{
			list1.add(result2.getString(1));
		}
		SoftAssert ast=new SoftAssert();
		ast.assertEquals(list, list1);
		System.out.println("busNames Verified sucessfully");
		ast.assertAll();

		connection.close();

	}
	
}
